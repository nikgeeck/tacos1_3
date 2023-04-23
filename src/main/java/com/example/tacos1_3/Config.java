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

//    @Bean
//    public CommandLineRunner dataLoader(
//            IngredientRepository repo,
//            UserRepository userRepo,
//            PasswordEncoder encoder,
//            TacoRepository tacoRepo) {
//        return args -> {
//            Ingredient flourTortilla = new Ingredient(
//                    "FLTO", "Flour Tortilla", Type.WRAP);
//            Ingredient cornTortilla = new Ingredient(
//                    "COTO", "Corn Tortilla", Type.WRAP);
//            Ingredient groundBeef = new Ingredient(
//                    "GRBF", "Ground Beef", Type.PROTEIN);
//            Ingredient carnitas = new Ingredient(
//                    "CARN", "Carnitas", Type.PROTEIN);
//            Ingredient tomatoes = new Ingredient(
//                    "TMTO", "Diced Tomatoes", Type.VEGGIES);
//            Ingredient lettuce = new Ingredient(
//                    "LETC", "Lettuce", Type.VEGGIES);
//            Ingredient cheddar = new Ingredient(
//                    "CHED", "Cheddar", Type.CHEESE);
//            Ingredient jack = new Ingredient(
//                    "JACK", "Monterrey Jack", Type.CHEESE);
//            Ingredient salsa = new Ingredient(
//                    "SLSA", "Salsa", Type.SAUCE);
//            Ingredient sourCream = new Ingredient(
//                    "SRCR", "Sour Cream", Type.SAUCE);
////            repo.save(flourTortilla);
////            repo.save(cornTortilla);
////            repo.save(groundBeef);
////            repo.save(carnitas);
////            repo.save(tomatoes);
////            repo.save(lettuce);
////            repo.save(cheddar);
////            repo.save(jack);
////            repo.save(salsa);
////            repo.save(sourCream);
//            Taco taco1 = new Taco();
//            taco1.setName("Carnivore");
//            taco1.setIngredients(Arrays.asList(
//                    flourTortilla, groundBeef, carnitas,
//                    sourCream, salsa, cheddar));
//            tacoRepo.save(taco1);
//            Taco taco2 = new Taco();
//            taco2.setName("Bovine Bounty");
//            taco2.setIngredients(Arrays.asList(
//                    cornTortilla, groundBeef, cheddar,
//                    jack, sourCream));
//            tacoRepo.save(taco2);
//            Taco taco3 = new Taco();
//            taco3.setName("Veg-Out");
//            taco3.setIngredients(Arrays.asList(
//                    flourTortilla, cornTortilla, tomatoes,
//                    lettuce, salsa));
//            tacoRepo.save(taco3);
//        };
//    }
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
