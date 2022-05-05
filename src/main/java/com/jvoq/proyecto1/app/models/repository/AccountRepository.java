package com.jvoq.proyecto1.app.models.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jvoq.proyecto1.app.models.entity.Account;

import reactor.core.publisher.Mono;

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
	@Query("{ 'idOwner': ?0 }")
	Mono<Account> findByIdClient(final String idClient);
}
