package com.cadenas.cadenas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CadenasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadenasApplication.class, args);
	}

	@RequestMapping("/")
	public String hola(){
		return "Saludos Cliente, como te encuentras el dia de hoy ?";
	}

	@RequestMapping("/random")
	public String mensajePositivo(){
		return "Me encanta Springboot para hacer rest apt!!!";
	}

}
