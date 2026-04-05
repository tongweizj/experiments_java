package com.vinay.web.flux;

/* Author: Vinay
 * COMP 303 - Enterprise App Development
 * Lab 9 Demo -  Creating a Spring Boot Flux app with MongoDB
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebFluxApplication.class, args);
		System.out.println("Spring Boot Web Flux App!!!");
	}

}
