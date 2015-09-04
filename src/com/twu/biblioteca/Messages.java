package com.twu.biblioteca;

import java.util.HashMap;

//Have Messages and return them.
public class Messages {
    private HashMap<String, String> messages;

    public Messages(HashMap messages) {
        this.messages = messages;
    }

    public String getUXMessage(String applicationMessage) {
        return messages.get(applicationMessage);
    }
}
