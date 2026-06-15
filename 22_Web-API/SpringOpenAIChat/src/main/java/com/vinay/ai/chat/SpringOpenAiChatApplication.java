package com.vinay.ai.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringOpenAiChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOpenAiChatApplication.class, args);
	}

}


/*
Chat
GET http://localhost:8080/api/chat?message=Hello
Streaming:
GET http://localhost:8080/api/stream?message=Tell me a joke
 * 
 */
