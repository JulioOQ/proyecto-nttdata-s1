package com.jvoq.proyecto1.app.models.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

	@Id
	private String idCliente;
	private String tipoDocumento;
	private String numDocumento;
	private String nombres;
	private String correo;
	private String direccion;
	private String telefono;	
	private String tipoCliente;
	@JsonIgnoreProperties({"idCliente","correo","direccion","telefono","tipoCliente","representantes","fechaCreacion"})
	private List<Client> representantes;
	private Date fechaCreacion;
	

}
