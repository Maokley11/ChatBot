package com.example.service_chatgptbot1.dialogs;

import com.example.service_chatgptbot1.models.QnAMakerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Component
public class QnaDialog {

    private final RestTemplate restTemplate;

    @Autowired
    public QnaDialog(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/getAnswerFromQnAMaker")
    public String getAnswerFromQnAMaker(@RequestBody String question) {
        // QnA-Maker-Endpunkt und API-Schlüssel
        String qnaMakerUrl = "https://projektserviebo.cognitiveservices.azure.com/language/:query-knowledgebases?projectName=serviceChatgptbot1&api-version=2021-10-01&deploymentName=test";
        String qnaMakerKey = "057e16f0-beee-49da-921c-815fbded3bd4";

        // JSON-Anfrage erstellen
        String requestBody = "{\"question\": \"" + question + "\"}";

        // Antwort von QnA-Maker abrufen
        QnAMakerResponse qnaMakerResponse = restTemplate.postForObject(qnaMakerUrl, requestBody, QnAMakerResponse.class);

        // Antwort verarbeiten und zurückgeben
        if (qnaMakerResponse != null && !qnaMakerResponse.getAnswers().isEmpty()) {
            return qnaMakerResponse.getAnswers().get(0).getAnswer(0);
        } else {
            return "Entschuldigung, ich konnte keine Antwort finden.";
        }
    }
}
