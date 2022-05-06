package com.jvoq.proyecto1.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvoq.proyecto1.app.models.entity.Account;
import com.jvoq.proyecto1.app.models.repository.AccountRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImplement implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	

	@Override
	public Flux<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Mono<Account> findById(String id) {
		return accountRepository.findById(id);
	}

	@Override
	public Mono<Account> save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Mono<Void> delete(Account account) {
		return accountRepository.delete(account);
	}

	@Override
	public Flux<Account> findAccoutsByIdClient(String idClient) {
		return accountRepository.findAccountByIdCliente(idClient);
	}

	


}
