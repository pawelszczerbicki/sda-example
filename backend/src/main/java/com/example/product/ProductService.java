package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void add(Product p){
        p.setId(UUID.randomUUID().toString());
        productRepository.addProduct(p);
    }

    public Optional<Product> getById(String id){
      return productRepository.getById(id);
    }

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Product update(String id, Product p) {
        Product fetched = getById(id).get();
        fetched.setName(p.getName());
        fetched.setPrice(p.getPrice());
        return fetched;
    }

    public void remove(String id) {
           productRepository.remove(id);
    }

    public boolean existsByName(String name) {
        return productRepository.getByName(name).isPresent();
    }
}
