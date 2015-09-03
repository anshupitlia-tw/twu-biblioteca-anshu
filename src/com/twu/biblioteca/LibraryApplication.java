package com.twu.biblioteca;

//The Bangalore Public Library
public class LibraryApplication {
    private UserInterface userInterface;

    public LibraryApplication(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void start() {
        userInterface.print("Welcome! Biblioteca at your service");
    }
}
