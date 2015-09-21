package com.twu.biblioteca.authentication;

import com.twu.biblioteca.factories.LibrarianMainMenuFactory;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.user_interface.UserInterface;

public class Librarian extends User {

    public Librarian(UserCredentials userCredentials, String name, String emailAddress, String phoneNumber) {
        super(userCredentials, name, emailAddress, phoneNumber);
    }

    public MainMenu getMainMenu(Session session, Library library, Messages messages, Users users, UserInterface userInterface) {
        return new LibrarianMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
    }
}
