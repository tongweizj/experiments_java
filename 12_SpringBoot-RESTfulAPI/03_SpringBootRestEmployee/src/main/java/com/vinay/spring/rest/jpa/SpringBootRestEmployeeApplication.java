package com.vinay.spring.rest.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestEmployeeApplication.class, args);
		System.out.println("Employee REST API is ready....");
	}
}
