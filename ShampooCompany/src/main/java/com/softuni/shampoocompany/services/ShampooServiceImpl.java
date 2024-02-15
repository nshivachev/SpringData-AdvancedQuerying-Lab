package com.softuni.shampoocompany.services;

import com.softuni.shampoocompany.entities.Shampoo;
import com.softuni.shampoocompany.entities.Size;
import com.softuni.shampoocompany.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findAllBySizeOrderById(String size) {
        return shampooRepository.findAllBySizeOrderById(Size.valueOf(size.toUpperCase()));
    }

    @Override
    public List<Shampoo> findAllBySizeOrLabelId(String size, String labelId) {
        return shampooRepository.findAllBySizeOrLabelId(Size.valueOf(size.toUpperCase()), Long.parseLong(labelId));
    }

    @Override
    public List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(String price) {
        return shampooRepository.findByPriceGreaterThanOrderByPriceDesc(new BigDecimal(price));
    }

    @Override
    public int countAllByPriceLessThan(String price) {
        return shampooRepository.countAllByPriceLessThan(new BigDecimal(price));
    }
}
