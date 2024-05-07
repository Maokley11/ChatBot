package com.example.service_chatgptbot1.models;

import java.util.List;

public class QnAMakerAnswer {

    private final List<String> answers;

    public QnAMakerAnswer(List<String> answers) {
        this.answers = answers;
    }

    // Methode, um die Antwort für den angegebenen Index zurückzugeben
    public String getAnswer(int index) {
        if (index >= 0 && index < answers.size()) {
            return answers.get(index);
        } else {
            return null; // oder eine Standardantwort, falls der Index ungültig ist
        }
    }

    // Weitere Methoden und Attribute je nach Bedarf
}
