package com.example.service_chatgptbot1.service;

import com.example.service_chatgptbot1.models.Luis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class LuisService {

    @Autowired
    public LuisService(RestTemplate restTemplate) {
    }

    public Luis getEntityFromLuis(String query) throws Exception {
        // Kodierung der Abfrage (Abfrage = Nachricht des Benutzers)
        query = URLEncoder.encode(query, StandardCharsets.UTF_8);
        // Neue Luis-Klasse erstellen
        Luis data = new Luis();
        URL url = new URL("https://westus.api.cognitive.microsoft.com/luis/v2.0/apps/2e145369-f8e9-4238-86de-8b6f7871182b?subscription-key=c92c7d6d010f419bb6c76fc23a4be53f&verbose=true&timezoneOffset=0&q=" + query);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // Antwort von JSON zu Java-Objekt konvertieren
            JSONObject jsonResponse = new JSONObject(response.toString());
            // Setze die Werte von data basierend auf jsonResponse
            // Beispiel: data.setSomeValue(jsonResponse.getString("someKey"));
        }
        return data;
    }
}
