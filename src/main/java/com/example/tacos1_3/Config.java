package com.example.tacos1_3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
@ComponentScan(basePackages = "com.*")
@EntityScan(basePackages = "com.model")
@EnableJpaRepositories(basePackages = "com.*")

public class Config implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        //registry.addViewController("/sosi").setViewName("sosi");
    }

//        @Bean("2")
//    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
//        List<UserDetails> users = new ArrayList<>();
//        users.add(
//                new User("buzz", encoder.encode("password"), List.of(new SimpleGrantedAuthority("ROLE_USER"))));
//        users.add(
//                new User("woody", encoder.encode("password"), List.of(new SimpleGrantedAuthority("ROLE_USER"))));
//
//        return new InMemoryUserDetailsManager(users);
//    }
}
