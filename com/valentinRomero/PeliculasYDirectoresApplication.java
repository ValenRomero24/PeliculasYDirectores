package com.valentinRomero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PeliculasYDirectoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeliculasYDirectoresApplication.class, args);
	}

	@GetMapping("/inicio")
	public String paginaInicial() {
		return "<h1>Hola desde mi primera app con Spring</h1>";
	}
}
