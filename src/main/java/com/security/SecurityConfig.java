package com.security;

import com.model.User;
import com.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Slf4j
@Configuration
@ComponentScan(basePackages = "com.*")
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests()
                .requestMatchers("/design", "/order").hasRole("USER")
                .requestMatchers(HttpMethod.POST, "/design").hasRole("USER")
                .requestMatchers("/", "/**").permitAll()
//                .anyRequest()
//                .authenticated()

                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)

                .and()
                .oauth2Login()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null) {
                log.info("User " + user.getFullname() + " found!");
                return user;
            }
            log.info("User doesn't exist!");
            throw new UsernameNotFoundException("User " + username + " not found");
        };
    }
}
