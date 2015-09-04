package com.twu.biblioteca;

import java.util.HashMap;

//Starts the application
public class BibliotecaApp {

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        HashMap<String, String> setUpMessages = new HashMap<>();
        setUpMessages.put("welcome_message", "Welcome! Biblioteca at your service");
        Messages messages = new Messages(setUpMessages);
        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages);
        libraryApplication.start();
    }
}
