package com.jvoq.proyecto1.app.models.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	@Id
	private String idCuenta;
	private String nombreCuenta;
	private double saldo;
	private String tipoCuenta;
	private String tipoMoneda;
}