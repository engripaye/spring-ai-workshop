package dev.engripaye.spring_ai_workshop.memory;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoryController {

    private final ChatClient chatClient;


    public MemoryController(ChatClient chatClient, ChatMemory chatMemory) {
        this.chatClient = ChatClient.builder(
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
        )
    }

    @GetMapping("/memory")
    public String memory(@RequestParam String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();

    }
}
