package com.twu.biblioteca.main;

import com.twu.biblioteca.authentication.Session;
import com.twu.biblioteca.controller.LibraryApplication;
import com.twu.biblioteca.factories.LibraryApplicationFactory;
import com.twu.biblioteca.factories.SessionFactory;

//Starts the application
public class BibliotecaApp {

    public static void main(String[] args) {
        Session session = new SessionFactory().createGuestSession();
        LibraryApplication libraryApplication = new LibraryApplicationFactory().getTheEstablishedLibraryApplication(session);
        libraryApplication.start();
        libraryApplication.controlUserChoice();
    }
}
