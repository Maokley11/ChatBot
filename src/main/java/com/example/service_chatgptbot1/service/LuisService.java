package com.example.service_chatgptbot1.service;

import com.example.service_chatgptbot1.models.Luis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class LuisService {

    private final RestTemplate restTemplate;

    @Autowired
    public LuisService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Luis getEntityFromLuis(String query) throws Exception {
        // Kodierung der Abfrage (Abfrage = Nachricht des Benutzers)
        query = URLEncoder.encode(query, StandardCharsets.UTF_8);
        // REST-Anfrage an LUIS senden und die Antwort abrufen
        String url = "https://projektserviebo.cognitiveservices.azure.com/language/:query-knowledgebases?projectName=serviceChatgptbot1&api-version=2021-10-01&deploymentName=test" + query;
        return restTemplate.getForObject(url, Luis.class);
    }
}
