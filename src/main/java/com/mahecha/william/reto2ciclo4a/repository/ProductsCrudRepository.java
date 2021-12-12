package com.mahecha.william.reto2ciclo4a.repository;

import com.mahecha.william.reto2ciclo4a.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsCrudRepository extends MongoRepository<Products, String> {
}
