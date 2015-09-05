package com.twu.biblioteca;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Setup {

    public LibraryApplication setTheLibraryUp() {
        UserInterface userInterface = new UserInterface();
        HashMap<String, String> setUpMessages = new HashMap<>();
        setUpMessages.put("welcome_message", "Welcome! Biblioteca at your service");
        Messages messages = new Messages(setUpMessages);
        List<String> listOfBooks = Arrays.asList(new String[]{"Anna Karenina", "Madame Bovary", "War and Peace", "Lolita", "The Adventures of Huckleberry Finn", "Hamlet", "The Great Gatsby", "In Search of Lost Time", "The Stories of Anton Chekhov", "Middlemarch"});
        Books books = new Books(listOfBooks);
        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, books);
        return libraryApplication;
    }
}
