package com.vinay.spring.flux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebFluxRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebFluxRestApplication.class, args);
		System.out.println("Spring Boot Webflux REST API started");
	}

}
