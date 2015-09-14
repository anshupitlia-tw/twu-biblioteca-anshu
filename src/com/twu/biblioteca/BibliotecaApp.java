package com.twu.biblioteca;

//Starts the application
public class BibliotecaApp {

    public static void main(String[] args) {
        LibraryApplication libraryApplication = new LibraryApplicationFactory().getTheEstablishedLibrary();
        libraryApplication.start();
        libraryApplication.controlUserChoice();
    }
}
