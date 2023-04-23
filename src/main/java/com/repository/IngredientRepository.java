package com.repository;

import com.model.Ingredient;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface IngredientRepository extends ListCrudRepository<Ingredient, String> {
//    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}