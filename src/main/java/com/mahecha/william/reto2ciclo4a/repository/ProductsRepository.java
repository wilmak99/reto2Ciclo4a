package com.mahecha.william.reto2ciclo4a.repository;

import com.mahecha.william.reto2ciclo4a.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductsRepository {
    @Autowired
    private ProductsCrudRepository productsCrudRepository;

    public List<Products> getAll() {
        return productsCrudRepository.findAll();
    }

    public Optional<Products> getProducts(String reference) {
        return productsCrudRepository.findById(reference);
    }

    public Products create(Products products) {
        return productsCrudRepository.save(products);
    }

    public void update(Products products) {
        productsCrudRepository.save(products);
    }

    public void delete(Products products) {
        productsCrudRepository.delete(products);
    }
}
