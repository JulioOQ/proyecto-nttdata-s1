package com.jvoq.proyecto1.app.controllers;

import java.net.URI;

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
import com.jvoq.proyecto1.app.models.entity.Company;
import com.jvoq.proyecto1.app.services.CompanyService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping
	public Mono<ResponseEntity<Flux<Company>>> listar() {
		return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(companyService.findAll()));
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Company>> verDetalle(@PathVariable String id) {
		return companyService.findById(id).map(c -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(c))
				.defaultIfEmpty(ResponseEntity.notFound().build());

	}

	@PostMapping
	public Mono<ResponseEntity<Company>> crear(@RequestBody Company company) {
		return companyService.save(company)
				.map(c -> ResponseEntity.created(URI.create("/companies".concat(c.getIdEmpresa())))
						.contentType(MediaType.APPLICATION_JSON).body(c));
	}

	@PutMapping("/{id}")
	public Mono<ResponseEntity<Company>> editar(@RequestBody Company company, @PathVariable String id) {
		return companyService.findById(id).flatMap(c -> {
			c.setNombreEmpresa(company.getNombreEmpresa());
			c.setRuc(company.getRuc());
			c.setDireccion(company.getDireccion());
			return companyService.save(c);
		}).map(c -> ResponseEntity.created(URI.create("/companies".concat(c.getIdEmpresa())))
				.contentType(MediaType.APPLICATION_JSON).body(c)).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> eliminar(@PathVariable String id) {
		return companyService.findById(id).flatMap(c -> {
			return companyService.delete(c).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}

}
