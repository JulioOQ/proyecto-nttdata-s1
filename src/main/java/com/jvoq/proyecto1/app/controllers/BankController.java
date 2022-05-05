package com.jvoq.proyecto1.app.controllers;

import java.net.URI;

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

import com.jvoq.proyecto1.app.models.entity.Bank;
import com.jvoq.proyecto1.app.services.BankService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/banks")
public class BankController {

	@Autowired
	BankService bankService;

	@GetMapping
	public Mono<ResponseEntity<Flux<Bank>>> getAll() {
		return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(bankService.findAll()));
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Bank>> getById(@PathVariable String id) {
		return bankService.findById(id).map(b -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(b))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Mono<ResponseEntity<Bank>> create(@RequestBody Bank bank) {
		return bankService.save(bank).map(b -> ResponseEntity.created(URI.create("/banks".concat(b.getIdBanco())))
				.contentType(MediaType.APPLICATION_JSON).body(b));
	}

	@PutMapping("/{id}")
	public Mono<ResponseEntity<Bank>> update(@RequestBody Bank bank, @PathVariable String id) {
		return bankService.findById(id).flatMap(b -> {
			b.setNombreBanco(bank.getNombreBanco());
			b.setTotalTransferencia(bank.getTotalTransferencia());
			b.setProduct(bank.getProduct());

			return bankService.save(b);
		}).map(b -> ResponseEntity.created(URI.create("/banks".concat(b.getIdBanco())))
				.contentType(MediaType.APPLICATION_JSON).body(b)).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> drop(@PathVariable String id) {
		return bankService.findById(id).flatMap(b -> {
			return bankService.delete(b).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
}
