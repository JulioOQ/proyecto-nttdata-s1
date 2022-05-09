package com.jvoq.proyecto1.app;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Microservicio Shared Database of Banks", version = "1.0", description = "Gestion de bancos"))
public class ProyectoSemana1Application {
	


	public static void main(String[] args) {
		SpringApplication.run(ProyectoSemana1Application.class, args);
	}

	
}
