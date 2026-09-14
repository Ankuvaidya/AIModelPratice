package com.ai.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OpenAiOllamaController {
//    private final ChatClient chatClient;
    private ChatClient openAiChatModel;

    private ChatClient ollamaChatModel;

    public OpenAiOllamaController(@Qualifier("openAiChatClient") ChatClient openAiChatModel, @Qualifier("ollamaChatClient") ChatClient ollamaChatModel) {
        this.openAiChatModel = openAiChatModel;
        this.ollamaChatModel = ollamaChatModel;
    }

//        public OpenAiOllamaController(OpenAiChatModel openAiChatModel, OllamaChatModel ollamaChatModel) {
//        this.openAiChatModel = ChatClient.builder(openAiChatModel).build();
//        this.ollamaChatModel = ChatClient.builder(ollamaChatModel).build();
//    }


//        public AiController(ChatClient.Builder builder) {
//        this.chatClient = builder.build();
//    }

    @GetMapping("/chat")
    public ResponseEntity<String> getChat(@RequestParam("q") String q) {
        String reply = ollamaChatModel.prompt()
                .user(q)
                .call()
                .content();
        return ResponseEntity.ok(reply);
    }
}
