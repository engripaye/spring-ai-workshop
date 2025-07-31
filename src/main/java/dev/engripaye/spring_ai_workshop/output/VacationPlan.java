package dev.engripaye.spring_ai_workshop.output;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationPlan {

    private final ChatClient chatClient;

    public VacationPlan(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/vacation/unstructured")
    public String unstructured(){
        return chatClient.prompt()
                .user("i  wanna plan a trip to lagos, give me the list of things to do")
                .call()
                .content();

                
    }

    @GetMapping("/vacation/structured")
    public Itinerary structured(){
        return chatClient.prompt()
                .user("i want a plan to visit ibadan, give me a list of things to do.")
                .call()
                .entity(Itinerary.class);
    }


}
