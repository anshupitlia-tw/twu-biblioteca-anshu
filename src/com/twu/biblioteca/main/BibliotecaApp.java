package com.twu.biblioteca.main;

import com.twu.biblioteca.controller.LibraryApplication;

//Starts the application
public class BibliotecaApp {

    public static void main(String[] args) {
        com.twu.biblioteca.authentication.Session session = new com.twu.biblioteca.factories.SessionFactory().createGuestSession();
        LibraryApplication libraryApplication = new com.twu.biblioteca.factories.LibraryApplicationFactory().getTheEstablishedLibraryApplication(session);
        libraryApplication.start();
        libraryApplication.controlUserChoice();
    }
}
