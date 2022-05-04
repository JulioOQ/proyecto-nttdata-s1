package com.jvoq.proyecto1.app.services;

import com.jvoq.proyecto1.app.models.entity.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

	public Flux<Product> findAll();

	public Mono<Product> findById(String id);

	public Mono<Product> save(Product product);

	public Mono<Void> delete(Product product);

}
