// ChatGPTRestController.java
package com.example.service_chatgptbot1.controller;

import com.example.service_chatgptbot1.models.SearchRequest;
import com.example.service_chatgptbot1.service.ChatGPTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class ChatGPTRestController {

    private final ChatGPTService chatGPTService;

    public ChatGPTRestController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }

    @PostMapping("/searchChatGPT")
    public String searchChatGPT(@RequestBody SearchRequest searchRequest){
        log.info("searchChatGPT start query:" + searchRequest.getQuery());
        return chatGPTService.sendMessage(searchRequest.getQuery());
    }
}