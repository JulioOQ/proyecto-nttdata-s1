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

import com.jvoq.proyecto1.app.models.entity.Account;
import com.jvoq.proyecto1.app.services.AccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping
	public Mono<ResponseEntity<Flux<Account>>> getAll() {
		return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(accountService.findAll()));
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Account>> getById(@PathVariable String id) {
		return accountService.findById(id).map(a -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(a))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Mono<ResponseEntity<Account>> create(@RequestBody Account account) {
		return accountService.save(account)
				.map(a -> ResponseEntity.created(URI.create("/accounts".concat(a.getIdCuenta())))
						.contentType(MediaType.APPLICATION_JSON).body(a));
	}

	@PutMapping("/{id}")
	public Mono<ResponseEntity<Account>> update(@RequestBody Account account, @PathVariable String id) {
		return accountService.findById(id).flatMap(a -> {
			//a.setNombreCuenta(account.getNombreCuenta());
			a.setSaldo(account.getSaldo());
			//a.setTipoCuenta(account.getTipoCuenta());
			a.setTipoMoneda(account.getTipoMoneda());
			a.setBank(account.getBank());

			return accountService.save(a);
		}).map(a -> ResponseEntity.created(URI.create("/accounts".concat(a.getIdCuenta())))
				.contentType(MediaType.APPLICATION_JSON).body(a)).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> drop(@PathVariable String id) {
		return accountService.findById(id).flatMap(a -> {
			return accountService.delete(a).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
}
