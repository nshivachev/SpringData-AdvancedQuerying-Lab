package com.softuni.shampoocompany.services;

import com.softuni.shampoocompany.entities.Ingredient;
import com.softuni.shampoocompany.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAllByNameStartingWith(String letter) {
        return ingredientRepository.findAllByNameStartingWith(letter.toUpperCase());
    }

    @Override
    public List<Ingredient> findAllByNameInOrderByPriceAsc(List<String> names) {
        return ingredientRepository.findAllByNameInOrderByPriceAsc(names);
    }
}
