package com.jvoq.proyecto1.app.services;

import com.jvoq.proyecto1.app.models.entity.Company;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyService {

	public Flux<Company> listar();

	public Mono<Company> findById(String id);

	public Mono<Company> save(Company company);

	public Mono<Void> delete(Company company);

}
