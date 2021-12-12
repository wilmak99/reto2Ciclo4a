package com.mahecha.william.reto2ciclo4a.controller;

import com.mahecha.william.reto2ciclo4a.model.Products;
import com.mahecha.william.reto2ciclo4a.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chocolate")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Products> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Products> getProduct(@PathVariable("reference") String reference) {
        return productService.getProducts(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Products create(@RequestBody Products products) {
        return productService.create(products);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Products update(@RequestBody Products products) {
        return productService.update(products);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return productService.delete(reference);
    }
}
