package com.fellipe.api_ai.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatClient chatClient;
    
    public ChatService(final ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
    
    String generateResponse(final String userInput) {
        return this.chatClient.prompt()
                              .user(userInput)
                              .call()
                              .content();
    }
}
