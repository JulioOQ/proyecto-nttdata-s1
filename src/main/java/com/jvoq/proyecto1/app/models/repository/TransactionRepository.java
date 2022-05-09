package com.jvoq.proyecto1.app.models.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.jvoq.proyecto1.app.models.entity.Transaction;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {

}
