package com.twu.biblioteca;

//Starts the application
public class BibliotecaApp {

    public static void main(String[] args) {
        EstablishLibrary setup = new EstablishLibrary();
        LibraryApplication libraryApplication = setup.getTheEstablishedLibrary();
        libraryApplication.start();
        libraryApplication.listMainMenu();
        libraryApplication.controlUserChoiceAndExecution();
    }
}
