package com.example.service_chatgptbot1.dialogs;

import com.example.service_chatgptbot1.service.LuisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class RootDialog implements IDialog<Object> {

    private final LuisService luisService;

    @Autowired
    public RootDialog(LuisService luisService) {
        this.luisService = luisService;
    }

    @Override
    public void StartAsync(IDialogContext context) {
        // Implementierung der Startlogik des Dialogs
        context.Wait("MessageReceivedOperationChoice");
    }

    void ResumeAfterFeedbackDialog(IDialogContext context, IAwaitable<object> result) {
        // Implementierung der Logik nach Abschluss des Feedback-Dialogs
    }

    void ResumeAfterQnaDialog(IDialogContext context) {
        // Implementierung der Logik nach Abschluss des QnA-Dialogs
    }

    private static class IMessageActivity {
    }

    private static class IAwaitable<T> {
        public IMessageActivity get() {
            return null;
        }
    }

    private static class async {
    }

    private static class object {
    }
}
