package com.twu.biblioteca;

public class Guest {

    public MainMenu getMainMenu(Session session, Library library, Messages messages, Users users, UserInterface userInterface) {
        return new GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface );
    }
}
