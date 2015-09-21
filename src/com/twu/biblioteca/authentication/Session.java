package com.twu.biblioteca.authentication;

import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.user_interface.UserInterface;

public class Session {
    private com.twu.biblioteca.authentication.Guest currentUser;

    public Session(com.twu.biblioteca.authentication.Guest currentUser) {
        this.currentUser = currentUser;
    }

    public com.twu.biblioteca.authentication.Guest getCurrentUser() {
        return currentUser;
    }


    public void putCurrentUser(com.twu.biblioteca.authentication.Guest currentUser) {
        this.currentUser = currentUser;
    }

    public MainMenu buildMainMenu(com.twu.biblioteca.models.Library library, Messages messages, com.twu.biblioteca.authentication.Users users, UserInterface userInterface ) {
        return this.getCurrentUser().getMainMenu(this, library, messages, users, userInterface);
    }
}
