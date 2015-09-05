package com.twu.biblioteca;

//The Bangalore Public Library Application
public class LibraryApplication {
    private UserInterface userInterface;
    private Messages messages;
    private Library library;

    public LibraryApplication(UserInterface userInterface, Messages messages, Library library) {
        this.userInterface = userInterface;
        this.messages = messages;
        this.library = library;
    }

    public void start() {
        userInterface.print(messages.getUXMessage("welcome_message"));
    }

    public void listBooks() {
        userInterface.print(library.getBookListForDisplay());
    }
}
