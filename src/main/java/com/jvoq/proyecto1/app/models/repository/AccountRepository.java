package com.jvoq.proyecto1.app.models.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.jvoq.proyecto1.app.models.entity.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
	
	
	Flux<Account> findAccountByIdCliente(String idClient);
	
	Mono<Account> findAccountByIdClienteAndIdProducto(String idClient,String idProduct);
}
