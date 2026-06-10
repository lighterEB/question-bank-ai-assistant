package github.lightereb.questionbankaiassistant.ai.controller;

import github.lightereb.questionbankaiassistant.ai.dto.ChatRequest;
import github.lightereb.questionbankaiassistant.ai.dto.ChatResponse;
import github.lightereb.questionbankaiassistant.ai.service.AiChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AiController {

    private final AiChatService aiChatService;

    @PostMapping("/ai/chat")
    public ChatResponse chat(@RequestBody ChatRequest chatRequest) {
        return aiChatService.chat(chatRequest);
    }
}
