package com.twu.biblioteca;

public class InvalidMenuItem extends MenuItem {
    private UserInterface userInterface;
    private Messages messages;

    InvalidMenuItem(UserInterface userInterface, Messages messages) {
        this.userInterface = userInterface;
        this.messages = messages;
    }
    @Override
    public void execute() {
        userInterface.printOnOutputStream(messages.getUXMessage("select_a_valid_option"));
    }
}
