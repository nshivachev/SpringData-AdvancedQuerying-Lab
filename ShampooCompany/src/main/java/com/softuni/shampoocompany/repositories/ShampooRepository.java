package com.softuni.shampoocompany.repositories;

import com.softuni.shampoocompany.entities.Shampoo;
import com.softuni.shampoocompany.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabelId(Size size, Long labelId);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countAllByPriceLessThan(BigDecimal price);

    @Query("SELECT s FROM Shampoo s JOIN s.ingredients i WHERE i.name IN :ingredientsNames")
    List<Shampoo> findByIngredients(List<String> ingredientsNames);

//    @Query("SELECT s FROM Shampoo s WHERE s.ingredients.size < :ingredientsCounts")
//    List<Shampoo> findByIngredientsCountLessThan(int ingredientsCounts);
}
