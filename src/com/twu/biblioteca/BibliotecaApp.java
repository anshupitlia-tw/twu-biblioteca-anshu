package com.twu.biblioteca;

//Starts the application
public class BibliotecaApp {

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        LibraryApplication libraryApplication = new LibraryApplication(userInterface);
        libraryApplication.start();
    }
}
