package com.jvoq.proyecto1.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvoq.proyecto1.app.models.entity.Client;
import com.jvoq.proyecto1.app.models.repository.ClientRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImplement implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Flux<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Mono<Client> findById(String id) {
		return clientRepository.findById(id);
	}

	@Override
	public Mono<Client> save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Mono<Void> delete(Client client) {
		return clientRepository.delete(client);
	}

}
