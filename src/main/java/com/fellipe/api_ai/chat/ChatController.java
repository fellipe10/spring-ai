package com.fellipe.api_ai.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    
    private final ChatClient chatClient;
    private final ChatService chatService;
    
    public ChatController(final ChatClient.Builder chatClientBuilder, final ChatService chatService) {
        this.chatClient = chatClientBuilder.build();
        this.chatService = chatService;
    }
    
    @PostMapping
    public ChatMessage simpleChat(@RequestBody final ChatMessage chatMessage) {
        final String response = this.chatClient.prompt()
                                               .user(chatMessage.message())
                                               .call()
                                               .content();
        return new ChatMessage(response);
    }
    
    @PostMapping("/whats")
    public ChatMessage chat(@RequestBody final ChatMessage chatMessage) {
       final String chat = this.chatService.generateResponse(chatMessage.message());
        return new ChatMessage(chat);
    }
}
