package com.twu.biblioteca;

import java.util.HashMap;

//The Bangalore Public Library
public class LibraryApplication {
    private UserInterface userInterface;
    private Messages messages;

    public LibraryApplication(UserInterface userInterface) {
        this.userInterface = userInterface;
        HashMap<String, String> setUpMessages = new HashMap<>();
        setUpMessages.put("welcome_message", "Welcome! Biblioteca at your service");
        messages = new Messages(setUpMessages);
    }

    public void start() {
        userInterface.print(messages.getUXMessage("welcome_message"));
    }
}
