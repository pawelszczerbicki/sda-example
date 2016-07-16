package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products", method = POST)
    public Product products(@RequestBody Product p) {
        if (StringUtils.isEmpty(p.getId())) productService.add(p);
        else productService.update(p.getId(), p);
        return p;
    }

    @RequestMapping(value = "/products/{id}", method = PUT)
    public Product update(@RequestBody Product p, @PathVariable String id) {
        return productService.update(id, p);
    }

    @RequestMapping(value = "/products/{id}", method = DELETE)
    public void remove(@PathVariable String id) {
        productService.remove(id);
    }

    @RequestMapping(value = "/products/{id}", method = GET)
    public Product getById(@PathVariable String id) {
        return productService.getById(id).get();
    }

    @RequestMapping(value = "/products", method = GET)
    public List<Product> getAll() {
        return productService.getAll();
    }


}
