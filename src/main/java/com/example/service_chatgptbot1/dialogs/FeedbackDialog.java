package com.example.service_chatgptbot1.dialogs;

import com.example.service_chatgptbot1.models.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Component
public class FeedbackDialog {

    // Dependency Injection von RestTemplate für die REST-Kommunikation
    private final RestTemplate restTemplate;

    // Konstruktor für die Dependency Injection
    @Autowired
    public FeedbackDialog(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Endpunkt-Mapping-Methode für die Einreichung von Feedback
    @PostMapping("/submit-feedback")
    public String submitFeedback(@RequestBody @Validated Feedback feedback) {
        // Feedback-Verarbeitung durch den externen Service
        restTemplate.postForObject("http://feedback-service/api/v1/feedback/submit", feedback, String.class);
        // Rückmeldung an den Benutzer über den erfolgreichen Feedback-Empfang
        return "Feedback submitted successfully!";
    }

    // Methode für die Bewertung des Bots durch den Benutzer
    public String askForRating() {
        // Logik für das Anfordern einer Bewertung vom Benutzer
        return "Kann man uns bewerten?";
    }

    // Antwort des Bots auf die Bewertungsanfrage
    public String botResponseToRatingRequest() {
        // Logik für die Antwort des Bots, die normalerweise etwas anderes sagt
        return "Ja, wir würden uns über eine Bewertung freuen! Bitte geben Sie Ihre Bewertung ein.";
    }
}
