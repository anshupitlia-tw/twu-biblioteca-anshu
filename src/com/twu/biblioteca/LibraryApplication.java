package com.twu.biblioteca;

//The Bangalore Public Library Application
public class LibraryApplication {
    private UserInterface userInterface;
    private Messages messages;

    public LibraryApplication(UserInterface userInterface, Messages messages) {
        this.userInterface = userInterface;
        this.messages = messages;
    }

    public void start() {
        userInterface.print(messages.getUXMessage("welcome_message"));
    }
}
