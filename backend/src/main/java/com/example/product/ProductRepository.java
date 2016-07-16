package com.example.product;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private List<Product> database = new ArrayList<>();

    @PostConstruct
    public void init() {
        Product p = new Product();
        p.setId(UUID.randomUUID().toString());
        p.setName("some");
        p.setPrice("1");
        database.add(p);
    }

    public void addProduct(Product p) {
        database.add(p);
    }

    public List<Product> getAll() {
        return database;
    }

    public static void main(String[] args) {
        int page = 1;
        int size = 1;
        new ArrayList<>().stream().skip(page * size).limit(size)
                .collect(Collectors.toList());

        new ArrayList<>().subList(page*size, page*size + size);
    }

    public Optional<Product> getById(String id) {

        return database.stream().filter(p -> id.equals(p.getId())).findAny();
    }

    public void remove(String id) {
        database.remove(getById(id).get());
    }

    public Optional<Product> getByName(String name) {
        return database.stream().filter(p -> p.getName().equals(name)).findAny();
    }
}
