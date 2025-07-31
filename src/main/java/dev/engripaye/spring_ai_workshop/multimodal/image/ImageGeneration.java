package dev.engripaye.spring_ai_workshop.multimodal.image;

import org.springframework.ai.image.ImageOptions;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ImageGeneration {

    private final OpenAiImageModel imageModel;


    public ImageGeneration(OpenAiImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public ResponseEntity<Map<String, String>> generateImage(@RequestParam(defaultValue = "A beautiful sunset") String prompt){

        ImageOptions imageOptions = OpenAiImageOptions.builder()
                .model("dell-o-3")
                .width(1024)
                .height(1024)
                .quality("hd")
                .style("vivid")
                .build();

        ImagePrompt imagePrompt = new ImagePrompt(prompt, imageOptions);
        ImageResponse imageResponse = imageModel.call(imagePrompt);

        String url = imageResponse.getResult().getOutput().getUrl();

        return ResponseEntity.ok(Map.of(
                "prompt", prompt,
                "imageUrl", url
        ));
    }
}
