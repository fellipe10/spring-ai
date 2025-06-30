package com.fellipe.api_ai;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ChatController {
    
    private final ChatClient chatClient;
    
    public ChatController(final ChatClient.Builder ChatClientBuilder) {
        this.chatClient = ChatClientBuilder.build();
    }
    
    @GetMapping("/ai")
    String generation(final String userInput){
        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }
    
    
    
}
