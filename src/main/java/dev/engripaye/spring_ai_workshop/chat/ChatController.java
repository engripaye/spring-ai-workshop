package dev.engripaye.spring_ai_workshop.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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

    @GetMapping("/stream")
    public Flux<String> stream(){
        return chatClient.prompt()
                .user("I'm visiting lagos")
                .stream()
                .content();
    }

    public ChatResponse joke() {
        return chatClient.prompt()
                .user("tell me a sweet joke")
                .call()
                .chatResponse();
    }


}
