package com.twu.biblioteca;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Starts the application
public class BibliotecaApp {

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        HashMap<String, String> setUpMessages = new HashMap<>();
        setUpMessages.put("welcome_message", "Welcome! Biblioteca at your service");
        Messages messages = new Messages(setUpMessages);
        List<String> listOfBooks = Arrays.asList(new String[] {"Anna Karenina", "Madame Bovary", "War and Peace", "Lolita", "The Adventures of Huckleberry Finn", "Hamlet", "The Great Gatsby", "In Search of Lost Time", "The Stories of Anton Chekhov", "Middlemarch"});
        Books books = new Books(listOfBooks);
        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, books);
        libraryApplication.start();
        libraryApplication.listBooks();
    }
}
