package com.fellipe.api_ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAiApplication.class, args);
		
		System.out.println("GOOGLE_APPLICATION_CREDENTIALS: " + System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
	}
	
	
}
