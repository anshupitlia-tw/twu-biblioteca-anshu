package com.twu.biblioteca.authentication;

public class Guest {

    public com.twu.biblioteca.main_menu.MainMenu getMainMenu(Session session, com.twu.biblioteca.models.Library library, com.twu.biblioteca.helpers.Messages messages, Users users, com.twu.biblioteca.user_interface.UserInterface userInterface) {
        return new com.twu.biblioteca.factories.GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface );
    }
}
