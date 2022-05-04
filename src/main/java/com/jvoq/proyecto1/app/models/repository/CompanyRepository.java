package com.jvoq.proyecto1.app.models.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jvoq.proyecto1.app.models.entity.Company;

public interface CompanyRepository extends ReactiveMongoRepository<Company, String> {

}
