package com.example.service_chatgptbot1.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class QnAMakerResponse {

    private List<QnAMakerAnswer> answers;

    public List<QnAMakerAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<QnAMakerAnswer> answers) {
        this.answers = answers;
    }
}

