package com.twu.biblioteca.authentication;

public class Librarian extends com.twu.biblioteca.authentication.User {

    public Librarian(UserCredentials userCredentials, String name, String emailAddress, String phoneNumber) {
        super(userCredentials, name, emailAddress, phoneNumber);
    }

    public com.twu.biblioteca.main_menu.MainMenu getMainMenu(Session session, com.twu.biblioteca.models.Library library, com.twu.biblioteca.helpers.Messages messages, Users users, com.twu.biblioteca.user_interface.UserInterface userInterface) {
        return new com.twu.biblioteca.factories.LibrarianMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
    }
}
