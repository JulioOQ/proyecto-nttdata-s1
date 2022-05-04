package com.jvoq.proyecto1.app.controllers;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvoq.proyecto1.app.models.entity.Product;
import com.jvoq.proyecto1.app.models.entity.Product;
import com.jvoq.proyecto1.app.services.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public Mono<ResponseEntity<Flux<Product>>> listar() {
		return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(productService.findAll()));
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Product>> verDetalle(@PathVariable String id) {
		return productService.findById(id).map(p -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(p))
				.defaultIfEmpty(ResponseEntity.notFound().build());

	}

	@PostMapping
	public Mono<ResponseEntity<Product>> crear(@RequestBody Product product) {
		return productService.save(product)
				.map(p -> ResponseEntity.created(URI.create("/products".concat(p.getIdProducto())))
						.contentType(MediaType.APPLICATION_JSON).body(p));
	}

	@PutMapping("/{id}")
	public Mono<ResponseEntity<Product>> editar(@RequestBody Product product, @PathVariable String id) {
		return productService.findById(id).flatMap(c -> {
			c.setNombreProducto(product.getNombreProducto());
			c.setDescripcion(product.getDescripcion());
			c.setTipoProducto(product.getTipoProducto());

			return productService.save(c);
		}).map(c -> ResponseEntity.created(URI.create("/products".concat(c.getIdProducto())))
				.contentType(MediaType.APPLICATION_JSON).body(c)).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> eliminar(@PathVariable String id) {
		return productService.findById(id).flatMap(c -> {
			return productService.delete(c).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}

}