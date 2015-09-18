package com.twu.biblioteca;

//Starts the application
public class BibliotecaApp {

    public static void main(String[] args) {
        Session session = new SessionFactory().createGuestSession();
        LibraryApplication libraryApplication = new LibraryApplicationFactory().getTheEstablishedLibraryApplication(session);
        libraryApplication.start();
        libraryApplication.controlUserChoice();
    }
}
