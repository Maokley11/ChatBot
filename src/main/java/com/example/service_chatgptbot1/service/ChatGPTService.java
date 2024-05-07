// ChatGPTService.java
package com.example.service_chatgptbot1.service;

import com.example.service_chatgptbot1.exception.ChatGPTException;
import com.example.service_chatgptbot1.models.ChatGPTRequest;
import com.example.service_chatgptbot1.models.ChatGPTResponse;

public abstract class ChatGPTService {
    public abstract String sendMessage(String message) throws ChatGPTException;
    public abstract ChatGPTResponse sendChatRequest(ChatGPTRequest chatRequest);
}