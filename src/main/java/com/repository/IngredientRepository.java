package com.repository;

import com.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;
//import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends ListCrudRepository<Ingredient, String> {
//    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}