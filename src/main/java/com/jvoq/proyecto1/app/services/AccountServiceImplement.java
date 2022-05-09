package com.jvoq.proyecto1.app.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvoq.proyecto1.app.models.entity.Account;

import com.jvoq.proyecto1.app.models.repository.AccountRepository;
import com.jvoq.proyecto1.app.models.repository.ClientRepository;
import com.jvoq.proyecto1.app.models.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class AccountServiceImplement implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public Flux<Account> findAll() {
		//log.info("listado con exito");
		return accountRepository.findAll().log();
	}

	@Override
	public Mono<Account> findById(String id) {
		return accountRepository.findById(id);
	}

	@Override
	public Mono<Account> save(Account account) {
		return this.findProductByIdClientAndIdProduct(account.getIdCliente(), account.getIdProducto())				
				.switchIfEmpty(accountRepository.save(account));				
	
	}

	@Override
	public Mono<Void> delete(Account account) {
		return accountRepository.delete(account);
	}

	@Override
	public Flux<Account> findAccoutsByIdClient(String idClient) {
		return accountRepository.findAccountByIdCliente(idClient);
	}

	@Override
	public Mono<Account> findProductByIdClientAndIdProduct(String idClient, String idProduct) {			
		return accountRepository.findAccountByIdClienteAndIdProducto(idClient, idProduct);
			
				
	}

	

	
	
	

	


}
