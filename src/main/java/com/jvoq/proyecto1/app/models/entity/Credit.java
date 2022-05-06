package com.jvoq.proyecto1.app.models.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "credits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Credit {

	@Id
	private String idCredito;
	private String idProducto;
	private String idCliente;
	private String numeroCredito;
	private String moneda;
	private Double lineaCredito;
	private Double saldo;
	private Double consumido;
	private Double interes;
	
}
