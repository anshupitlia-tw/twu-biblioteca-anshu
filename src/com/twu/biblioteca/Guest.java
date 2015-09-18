package com.twu.biblioteca;

public class Guest {
    protected MainMenu mainMenu;

    public MainMenu getMainMenu(Session session) {
        return new GuestUserMainMenuFactory().establishMainMenu(session);
    }
}
