package com.twu.biblioteca;

public class Librarian extends User{

    Librarian(UserCredentials userCredentials, String name, String emailAddress, String phoneNumber) {
        super(userCredentials, name, emailAddress, phoneNumber);
    }

    public MainMenu getMainMenu(Session session, Library library, Messages messages, Users users, UserInterface userInterface) {
        return new LibrarianMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
    }
}
