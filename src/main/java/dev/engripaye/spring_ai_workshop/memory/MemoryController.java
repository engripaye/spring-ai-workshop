package dev.engripaye.spring_ai_workshop.memory;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemoryController {

    private final ChatClient chatClient;

    public MemoryController(OpenAiChatModel chatModel, ChatMemory chatMemory) {
        this.chatClient = ChatClient.create(
                chatModel // ✅ First: provide ChatModel
                // ✅ Second: add memory
        );
    }

    @GetMapping("/memory")
    public String memory(@RequestParam String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
