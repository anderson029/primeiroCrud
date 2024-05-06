package com.nelioalves.primeiroCrud;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// TODO: Criar README
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Gestão Funcionários", version = "1.0", description = "Gestão de funcionários"))
public class PrimeiroCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroCrudApplication.class, args);
	}
}
