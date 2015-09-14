package com.twu.biblioteca;

public class UserInterfaceFactory {

    private UserInterface userInterface;

    public UserInterface establishUserInterface() {
        userInterface = new UserInterface(System.in, System.out, System.err);
        return userInterface;
    }
}
