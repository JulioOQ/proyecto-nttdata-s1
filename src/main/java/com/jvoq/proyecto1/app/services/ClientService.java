package com.jvoq.proyecto1.app.services;

import com.jvoq.proyecto1.app.models.entity.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

	public Flux<Client> findAll();

	public Mono<Client> findById(String id);

	public Mono<Client> save(Client client);

	public Mono<Void> delete(Client client);
}
