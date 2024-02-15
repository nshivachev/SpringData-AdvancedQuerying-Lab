package com.softuni.shampoocompany.services;

import com.softuni.shampoocompany.entities.Shampoo;

import java.util.List;

public interface ShampooService {
    List<Shampoo> findAllBySizeOrderById(String size);

    List<Shampoo> findAllBySizeOrLabelId(String size, String labelId);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(String price);

    int countAllByPriceLessThan(String price);
}
