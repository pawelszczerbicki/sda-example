package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static com.example.config.Keys.PRODUCT_EXISTS;

@Component
public class ProductValidator implements Validator {
    @Autowired
    private ProductService productService;


    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product p = (Product) target;
        if (productService.existsByName(p.getName()))
            errors.reject(PRODUCT_EXISTS);
    }
}
