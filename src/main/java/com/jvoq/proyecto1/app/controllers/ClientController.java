package com.jvoq.proyecto1.app.controllers;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvoq.proyecto1.app.models.entity.Client;
import com.jvoq.proyecto1.app.services.ClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public Mono<ResponseEntity<Flux<Client>>> getAll() {
		return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(clientService.findAll()));
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Client>> getById(@PathVariable String id) {
		return clientService.findById(id).map(c -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(c))
				.defaultIfEmpty(ResponseEntity.notFound().build());

	}

	@PostMapping
	public Mono<ResponseEntity<Client>> create(@RequestBody Client client) {
		if (client.getFechaCreacion() == null) {
			client.setFechaCreacion(new Date());

		}
		return clientService.save(client)
				.map(c -> ResponseEntity.created(URI.create("/clients".concat(c.getIdCliente())))
						.contentType(MediaType.APPLICATION_JSON).body(c));
	}

	@PutMapping("/{id}")
	public Mono<ResponseEntity<Client>> update(@RequestBody Client client, @PathVariable String id) {
		return clientService.findById(id).flatMap(c -> {
			c.setNombres(client.getNombres());
			c.setCorreo(client.getCorreo());
			c.setNumDocumento(client.getNumDocumento());

			return clientService.save(c);
		}).map(c -> ResponseEntity.created(URI.create("/clients".concat(c.getIdCliente())))
				.contentType(MediaType.APPLICATION_JSON).body(c)).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> drop(@PathVariable String id) {
		return clientService.findById(id).flatMap(c -> {
			return clientService.delete(c).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}

}
