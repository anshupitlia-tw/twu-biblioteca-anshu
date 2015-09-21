package com.twu.biblioteca.authentication;

import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.user_interface.UserInterface;

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
