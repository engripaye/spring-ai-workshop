package dev.engripaye.spring_ai_workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAiWorkshopApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application-secrets");
		SpringApplication.run(SpringAiWorkshopApplication.class, args);
	}

}
