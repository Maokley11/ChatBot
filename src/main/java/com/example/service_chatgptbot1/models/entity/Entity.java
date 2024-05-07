package com.example.service_chatgptbot1.models.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Weitere gemeinsame Eigenschaften oder Methoden für alle Entitäten können hier hinzugefügt werden
}
