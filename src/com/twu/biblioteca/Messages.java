package com.twu.biblioteca;

import java.util.HashMap;

public class Messages {
    private HashMap<String, String> messages;

    Messages(HashMap messages) {
        this.messages = messages;
    }

    public String getUXMessage(String applicationMessage) {
        return messages.get(applicationMessage);
    }
}
