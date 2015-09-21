package com.twu.biblioteca.authentication;

import com.twu.biblioteca.factories.GuestUserMainMenuFactory;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.user_interface.UserInterface;

public class Guest {

    public MainMenu getMainMenu(Session session, Library library, Messages messages, Users users, UserInterface userInterface) {
        return new GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface );
    }
}
