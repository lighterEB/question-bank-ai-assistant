package github.lightereb.questionbankaiassistant.ai.service;

import github.lightereb.questionbankaiassistant.ai.dto.ChatRequest;
import github.lightereb.questionbankaiassistant.ai.dto.ChatResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiChatService {

    private final ChatClient chatClient;

    public AiChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public ChatResponse chat(ChatRequest chatRequest) {
        long startTime = System.currentTimeMillis();
        org.springframework.ai.chat.model.ChatResponse response = chatClient.prompt()
                .user(chatRequest.message())
                .call()
                .chatResponse();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        String content = null;
        String modelName = null;
        if (response != null) {
            content = response.getResult().getOutput().getText();
            modelName = response.getMetadata().getModel();
        }
        return new ChatResponse(content, modelName, duration);
    }
}
