package com.jvoq.proyecto1.app.models.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jvoq.proyecto1.app.models.entity.Account;

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {

}
