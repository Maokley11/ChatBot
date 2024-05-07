package com.example.service_chatgptbot1.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "chatgpt")
public class ChatGPTProperties {

    @Value("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")
    private String openAiKey;

    @Value("a79d9d80-a06f-4f83-b1eb-359a697f3d69")
    private String luisEndpoint;

    @Value("gvgpb6lkioitn3wfymtjfijpndedfkgmvvry11wc")
    private String luisKey;

    @Value("a79d9d80-a06f-4f83-b1eb-359a697f3d69")
    private String qnaMakerEndpoint;

    @Value("gvgpb6lkioitn3wfymtjfijpndedfkgmvvry11wc")
    private String qnaMakerKey;

    // Getter und Setter für alle Eigenschaften

    public String getOpenAiKey() {
        return openAiKey;
    }

    public void setOpenAiKey(String openAiKey) {
        this.openAiKey = openAiKey;
    }

    public String getLuisEndpoint() {
        return luisEndpoint;
    }

    public void setLuisEndpoint(String luisEndpoint) {
        this.luisEndpoint = luisEndpoint;
    }

    public String getLuisKey() {
        return luisKey;
    }

    public void setLuisKey(String luisKey) {
        this.luisKey = luisKey;
    }

    public String getQnaMakerEndpoint() {
        return qnaMakerEndpoint;
    }

    public void setQnaMakerEndpoint(String qnaMakerEndpoint) {
        this.qnaMakerEndpoint = qnaMakerEndpoint;
    }

    public String getQnaMakerKey() {
        return qnaMakerKey;
    }

    public void setQnaMakerKey(String qnaMakerKey) {
        this.qnaMakerKey = qnaMakerKey;
    }

    public int getMaxTokens() {
        return 500; // Beispielwert, bitte anpassen
    }

    public int getApiKey() {
        return 0;
    }

    public int getModel() {
        return 0;
    }
}
