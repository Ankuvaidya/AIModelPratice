package com.ai.ollamaDemo.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OllamaController {

    private final ChatClient chatClient;

    public OllamaController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/ollama/chat")
    public ResponseEntity<String> getOllama(@RequestParam(name = "q", defaultValue = "true") String q) {
        String reply = chatClient.prompt()
                .user(q)
                .call()
                .content();
        return ResponseEntity.ok(reply);
    }
}