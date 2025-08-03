package com.chatbot.ai.Chatbot.AI.controller;

import com.chatbot.ai.Chatbot.AI.model.ChatRequest;
import com.chatbot.ai.Chatbot.AI.model.ChatResponse;
import com.chatbot.ai.Chatbot.AI.service.OpenAIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = {"http://localhost:3000", "https://melodious-douhua-1e23c1.netlify.app/"})
public class ChatController {

    private final OpenAIService openAIService;

    public ChatController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String response = openAIService.generateReply(request.getMessage());
        return new ChatResponse(response);
    }
}