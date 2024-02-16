package com.softuni.shampoocompany.repositories;

import com.softuni.shampoocompany.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith(String letter);

    List<Ingredient> findAllByNameInOrderByPriceAsc(List<String> ingredientsNames);

    void deleteByName(String name);

    @Query("UPDATE Ingredient i SET i.price = i.price * 1.10")
    @Modifying
    void updateAllPrice();

    @Query("UPDATE Ingredient i SET i.price = i.price * 1.10 WHERE i.name IN :ingredientsNames")
    @Modifying
    void updatePriceByName(List<String> ingredientsNames);
}
