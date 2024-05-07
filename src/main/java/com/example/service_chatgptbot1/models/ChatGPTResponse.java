package com.example.service_chatgptbot1.models;
import lombok.Data;

import java.util.List;

@Data
public class ChatGPTResponse {
    private List<Choice> choices;

    @Data
    public static class Choice {
        private String text;
        // Weitere Eigenschaften je nach Bedarf, z. B. confidence score
    }
}