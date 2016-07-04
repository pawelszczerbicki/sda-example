package com.example.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ProductController {

    @RequestMapping(value = "/products", method = POST)
    public Product products(Product p ){
        return p;
    }
}
