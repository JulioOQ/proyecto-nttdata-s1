package com.jvoq.proyecto1.app.services;

import com.jvoq.proyecto1.app.models.entity.Transaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

	public Flux<Transaction> findAll();

	public Mono<Transaction> findById(String id);

	public Mono<Transaction> save(Transaction transaction);

	public Mono<Void> delete(Transaction transaction);
}
