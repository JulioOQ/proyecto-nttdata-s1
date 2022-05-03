package com.jvoq.proyecto1.app.models.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection = "banks")
public class Bank {
	
	@Id
	private String idBanco;
	private String nombreBanco;
	private String totalTransferencia;
		
	
	
	public Bank(String idBanco, String nombreBanco, String totalTransferencia) {
		super();
		this.idBanco = idBanco;
		this.nombreBanco = nombreBanco;
		this.totalTransferencia = totalTransferencia;
	}
	
	public Bank() {
		
	}
	
	
	
	public String getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(String idBanco) {
		this.idBanco = idBanco;
	}
	public String getNombreBanco() {
		return nombreBanco;
	}
	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}
	public String getTotalTransferencia() {
		return totalTransferencia;
	}
	public void setTotalTransferencia(String totalTransferencia) {
		this.totalTransferencia = totalTransferencia;
	}
	
	
	
	
	

	
}
