package com.twu.biblioteca.factories;

import com.twu.biblioteca.user_interface.UserInterface;

public class UserInterfaceFactory {

    private UserInterface userInterface;

    public UserInterface establishUserInterface() {
        userInterface = new UserInterface(System.in, System.out, System.err);
        return userInterface;
    }
}
