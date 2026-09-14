package com.ai.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AiController {
    private final ChatClient chatClient;

    public AiController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> getChat(@RequestParam("q") String q) {
        String reply = chatClient.prompt()
                .user(q)
                .call()
                .content();
        return ResponseEntity.ok(reply);
    }
}
