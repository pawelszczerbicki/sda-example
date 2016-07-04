package com.example.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> database = new ArrayList<>();

    public void addProduct(Product p) {
       database.add(p);
    }

    public List<Product> getAll(){
        return database;
    }
}
