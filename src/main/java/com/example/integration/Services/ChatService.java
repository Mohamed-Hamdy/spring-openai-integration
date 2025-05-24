package com.example.integration.Services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String getChatResponse(String prompt) {
        try {
            return chatClient
                    .prompt(prompt)
                    .call()
                    .content();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get response from chat client", e);
        }
    }
}
