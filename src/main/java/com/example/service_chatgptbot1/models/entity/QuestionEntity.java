package com.example.service_chatgptbot1.models.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer; // Beziehung zu CustomerEntity

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // Konstruktoren, Getter und Setter können hier hinzugefügt werden
}