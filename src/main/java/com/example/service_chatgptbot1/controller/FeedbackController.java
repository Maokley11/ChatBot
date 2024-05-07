package com.example.service_chatgptbot1.controller;

import com.example.service_chatgptbot1.models.Feedback;
import com.example.service_chatgptbot1.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/submit")
    public String submitFeedback(@RequestBody Feedback feedback) {
        // Feedback-Verarbeitung durch den Service
        feedbackService.processFeedback(feedback);
        return "Feedback submitted successfully!";
    }
}