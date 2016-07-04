package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @RequestMapping(value = "/products", method = POST)
    public Product products(Product p) {
        repository.addProduct(p);
        return p;
    }

    @RequestMapping(value = "/products", method = GET)
    public List<Product> getAll() {
        return repository.getAll();
    }
}
