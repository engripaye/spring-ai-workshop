package dev.engripaye.spring_ai_workshop.multimodal.image;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageDetection {

    private final ChatClient chatClient;
    @Value("classpath:/images/f6.png")
    Resource sampleImage;
    public ImageDetection(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("image-to-text")
    public String imageToText(){
        return chatClient.prompt()
                .user(u-> {
                    u.text("can you describe the image");
                    u.media(MimeTypeUtils.IMAGE_PNG,sampleImage);
                })
                .call()
                .content();
    }



}
