package com.example.service_chatgptbot1.service;

import com.example.service_chatgptbot1.models.Feedback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Override
    public void processFeedback(Feedback feedback) {
        // Hier wird das Feedback verarbeitet, z. B. gespeichert oder weitergeleitet
        log.info("Feedback erhalten : {}", feedback);
    }
}
