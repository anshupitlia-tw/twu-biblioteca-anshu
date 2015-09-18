package com.twu.biblioteca;

public class Librarian extends User{

    Librarian(UserCredentials userCredentials) {
        super(userCredentials);
    }

    public MainMenu getMainMenu(Session session) {
        return new LibrarianMainMenuFactory().establishMainMenu(session);
    }
}
