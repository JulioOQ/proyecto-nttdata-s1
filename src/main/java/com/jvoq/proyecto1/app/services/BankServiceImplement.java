package com.jvoq.proyecto1.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvoq.proyecto1.app.models.entity.Bank;
import com.jvoq.proyecto1.app.models.repository.BankRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankServiceImplement implements BankService {

	@Autowired
	BankRepository bankRepository;

	@Override
	public Flux<Bank> findAll() {
		return bankRepository.findAll();
	}

	@Override
	public Mono<Bank> findById(String id) {
		return bankRepository.findById(id);
	}

	@Override
	public Mono<Bank> save(Bank bank) {
		return bankRepository.save(bank);
	}

	@Override
	public Mono<Void> delete(Bank bank) {
		return bankRepository.delete(bank);
	}

}
