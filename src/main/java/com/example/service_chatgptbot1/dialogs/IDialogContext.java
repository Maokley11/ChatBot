package com.example.service_chatgptbot1.dialogs;

import java.awt.*;

public interface IDialogContext {

    void Wait(MessageReceivedOperationChoice choice);

    void PostAsync(String message);

    void Forward(Dialog dialog, Object argument);

    void Wait(String messageReceivedOperationChoice);

    class MessageReceivedOperationChoice {
    }

    // Weitere Methoden je nach Bedarf
}
