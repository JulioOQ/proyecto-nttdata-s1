package com.jvoq.proyecto1.app.models.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Document(collection = "banks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
	
	@Id
	private String idBanco;
	private String nombreBanco;
	private String totalTransferencia;
		
	
	
	
	

	
}
