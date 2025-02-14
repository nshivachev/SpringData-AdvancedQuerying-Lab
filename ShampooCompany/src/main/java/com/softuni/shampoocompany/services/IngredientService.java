package com.softuni.shampoocompany.services;

import com.softuni.shampoocompany.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAllByNameStartingWith(String letter);

    List<Ingredient> findAllByNameInOrderByPriceAsc(List<String> names);

    void deleteByName(String name);

    void updateAllPrice();

    void updatePriceByName(List<String> ingredientsNames);
}
