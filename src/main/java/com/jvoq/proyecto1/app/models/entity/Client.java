package com.jvoq.proyecto1.app.models.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.transaction.annotation.Transactional;




@Document(collection = "clients")
public class Client {
	
	@Id	
	private String idCliente;	
	private String nombres;
	private String numDocumento;
	private String correo;	
	private Date fechaCreacion;
	
	
	
	public Client(String nombres, String numDocumento, String correo) {
		this.nombres = nombres;
		this.numDocumento = numDocumento;
		this.correo = correo;
		
	}
		
	public Client() {
		
	}
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getNumDocumento() {
		return numDocumento;
	}
	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
	
	
}
