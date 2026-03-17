package com.devlimas.sistema_pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SistemaPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaPedidosApplication.class, args);
	}

}
