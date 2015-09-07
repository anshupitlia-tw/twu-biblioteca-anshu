package com.twu.biblioteca;

//Starts the application
public class BibliotecaApp {

    public static void main(String[] args) {
        Setup setup = new Setup();
        LibraryApplication libraryApplication = setup.setTheLibraryUp();
        libraryApplication.start();
        libraryApplication.listMainMenu();
        libraryApplication.getUserChoiceAndDelegate();
    }
}
