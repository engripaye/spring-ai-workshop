package dev.engripaye.spring_ai_workshop.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public String chat(){
        return chatClient.prompt()
                .user("Tell me an interesting fact about java")
                .call()
                .content();
    }
}
