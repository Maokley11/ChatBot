// ChatGPTException.java
package com.example.service_chatgptbot1.exception;

public class ChatGPTException extends RuntimeException {

    public ChatGPTException(String message){
        super(message);
    }

    public ChatGPTException(String errorParsingChatGPTResponse, Exception e) {
    }
}