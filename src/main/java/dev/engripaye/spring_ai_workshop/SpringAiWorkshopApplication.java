package dev.engripaye.spring_ai_workshop;

import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiWorkshopApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application-secrets");
		SpringApplication.run(SpringAiWorkshopApplication.class, args);
	}

}
