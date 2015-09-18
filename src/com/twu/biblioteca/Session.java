package com.twu.biblioteca;

public class Session {
    private Guest currentUser;

    public Session(Guest currentUser) {
        this.currentUser = currentUser;
    }

    public Guest getCurrentUser() {
        return currentUser;
    }


    public void putCurrentUser(Guest currentUser) {
        this.currentUser = currentUser;
    }

    public MainMenu buildMainMenu(Library library, Messages messages, Users users, UserInterface userInterface ) {
        return this.getCurrentUser().getMainMenu(this, library, messages, users, userInterface);
    }
}
