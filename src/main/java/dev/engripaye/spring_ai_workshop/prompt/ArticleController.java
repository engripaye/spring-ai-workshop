package dev.engripaye.spring_ai_workshop.prompt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    private final ChatClient chatClient;

    public ArticleController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/post/new")
    public String newPost(@RequestParam(value = "topic", defaultValue = "JDK Virtual thread") String topic){

        var system = """
                
                General Blog Post
                
                
                
                """;

        return chatClient.prompt()
                .user(u -> {
                    u.text("Write me a blog ...");
                    u.param("topic", topic);
                })
                .system(system)
                .call()
                .content();
    }
}
