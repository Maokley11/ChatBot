package com.example.service_chatgptbot1.models;

import lombok.Data;

@Data
public class ChatGPTRequest {
    private String model;
    private String message;
    private Integer maxTokens;
    private Double temperature;
    private Double topP;

    public ChatGPTRequest(String model, String message, Integer maxTokens, Double temperature, Object topP) {
    }

    // Konstruktor, Getter und Setter
}