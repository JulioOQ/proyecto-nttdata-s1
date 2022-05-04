package com.jvoq.proyecto1.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvoq.proyecto1.app.models.entity.Company;
import com.jvoq.proyecto1.app.models.repository.CompanyRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompanyServiceImplement implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Flux<Company> listar() {
		return companyRepository.findAll();
	}

	@Override
	public Mono<Company> findById(String id) {
		return companyRepository.findById(id);
	}

	@Override
	public Mono<Company> save(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public Mono<Void> delete(Company company) {
		return companyRepository.delete(company);
	}

}
