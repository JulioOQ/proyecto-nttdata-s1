package com.jvoq.proyecto1.app.models.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	private String idProducto;
	private String nombreProducto;
	private String descripcion;
	private String tipoProducto;
	private List<Account> accounts;
	private List<Credit> credits;
}
