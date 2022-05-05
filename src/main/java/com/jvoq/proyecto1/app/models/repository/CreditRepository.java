package com.jvoq.proyecto1.app.models.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jvoq.proyecto1.app.models.entity.Credit;

public interface CreditRepository extends ReactiveMongoRepository<Credit, String> {

}
