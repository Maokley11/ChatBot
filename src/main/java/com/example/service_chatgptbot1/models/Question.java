package com.example.service_chatgptbot1.models;

import lombok.Data;

@Data
public class Question {
    private Long id;
    private String content;
    private Customer customer; // Beziehung zu Customer

    // Konstruktoren, Getter und Setter können hier hinzugefügt werden
}