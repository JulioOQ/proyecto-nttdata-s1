package com.jvoq.proyecto1.app.models.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jvoq.proyecto1.app.models.entity.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
