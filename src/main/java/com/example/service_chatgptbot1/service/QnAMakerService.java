package com.example.service_chatgptbot1.service;

import com.example.service_chatgptbot1.models.QnAMakerResponse;
import com.example.service_chatgptbot1.property.ChatGPTProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class QnAMakerService {

    private final ChatGPTProperties chatGPTProperties;
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public QnAMakerService(ChatGPTProperties chatGPTProperties) {
        this.chatGPTProperties = chatGPTProperties;
    }

    public String getAnswerFromQnAMaker(String question) {
        // HTTP-Anfrage an die QnA-Maker-API senden
        String qnaMakerUrl = chatGPTProperties.getQnaMakerEndpoint();
        String qnaMakerKey = chatGPTProperties.getQnaMakerKey();
        String requestBody = "{\"question\": \"" + question + "\"}";
        QnAMakerResponse qnaMakerResponse = restTemplate.postForObject(qnaMakerUrl, requestBody, QnAMakerResponse.class);

        // Antwort verarbeiten und Antwortnachricht zurückgeben
        if (qnaMakerResponse != null && !qnaMakerResponse.getAnswers().isEmpty()) {
            return qnaMakerResponse.getAnswers().get(0).getAnswer(0);
        } else {
            return "Sorry, ich konnte keine Antwort finden.";
        }
    }
}
