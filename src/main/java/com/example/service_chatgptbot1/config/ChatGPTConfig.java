package com.example.service_chatgptbot1.config;

import com.example.service_chatgptbot1.property.ChatGPTProperties;
import com.example.service_chatgptbot1.service.ChatGPTService;
import com.example.service_chatgptbot1.service.ChatGPTServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(ChatGPTProperties.class)
public class ChatGPTConfig {

    private final ChatGPTProperties chatGPTProperties;

    public ChatGPTConfig(ChatGPTProperties chatGPTProperties){
        this.chatGPTProperties = chatGPTProperties;
        log.debug("chatgpt-springboot-starter loaded.");
    }

    @Bean
    @ConditionalOnMissingBean(ChatGPTService.class)
    public ChatGPTService chatGPTService(){
        return new ChatGPTServiceImpl(chatGPTProperties);
    }
}
