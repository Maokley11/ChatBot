package com.example.service_chatgptbot1.models.entity;

import com.example.service_chatgptbot1.models.Question;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Question> questions; // Beziehung zu Question

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // Konstruktoren, Getter und Setter können hier hinzugefügt werden
}
