package com.softuni.shampoocompany.repositories;

import com.softuni.shampoocompany.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith(String letter);

    List<Ingredient> findAllByNameInOrderByPriceAsc(List<String> names);
}
