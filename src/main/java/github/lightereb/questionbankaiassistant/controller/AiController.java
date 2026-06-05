package github.lightereb.questionbankaiassistant.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    private final ChatClient chatClient;

    public AiController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/ai/chat")
    public String chat(@RequestParam(defaultValue = "用一句话介绍你自己") String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
