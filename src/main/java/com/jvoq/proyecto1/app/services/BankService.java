package com.jvoq.proyecto1.app.services;

import com.jvoq.proyecto1.app.models.entity.Bank;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankService {

	public Flux<Bank> findAll();

	public Mono<Bank> findById(String id);

	public Mono<Bank> save(Bank bank);

	public Mono<Void> delete(Bank bank);
}
