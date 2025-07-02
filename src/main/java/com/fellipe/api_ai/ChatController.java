package com.fellipe.api_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    
    private final ChatClient chatClient;
    
    public ChatController(final ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
    
    @GetMapping("/ai")
    String generation(@RequestParam String userInput){
        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }
    
    @PostMapping
    String chatPost(@RequestBody  String userInput){
        return this.chatClient.prompt()
                              .user(userInput)
                              .call()
                              .content();
    }
    
}
