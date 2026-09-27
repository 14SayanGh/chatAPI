package com.sayan.chatapi.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayan.chatapi.dto.ChatResponse;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class ChatController {

    private ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from Chat API..");
    }

    @GetMapping("/chat")
    public ResponseEntity<ChatResponse> chat(@RequestParam String query) {
        String response = chatClient.prompt(query)
                .system("""
                        Explain answers clearly and use simple examples.
                                """)
                .call()
                .content();
        return ResponseEntity.ok(new ChatResponse(response));
    }

}
