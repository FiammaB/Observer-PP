package com.PP.ObserverSpringBoot;

import com.PP.ObserverSpringBoot.Service.UsuarioServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ObserverSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObserverSpringBootApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(UsuarioServicio userService) {
		return args -> {
			System.out.println("\n--- Iniciando prueba del patrón Observer ---");
			userService.registerUser("juanperez", "juan.perez@example.com");
			System.out.println("--- Prueba del patrón Observer finalizada ---\n");
		};
	}
}
