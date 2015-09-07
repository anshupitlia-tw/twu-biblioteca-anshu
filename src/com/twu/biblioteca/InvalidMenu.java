package com.twu.biblioteca;

public class InvalidMenu implements AMenu {
    private UserInterface userInterface;
    private Messages messages;

    InvalidMenu(UserInterface userInterface, Messages messages) {
        this.userInterface = userInterface;
        this.messages = messages;
    }
    @Override
    public void execute() {
        userInterface.print(messages.getUXMessage("select_a_valid_option"));
    }
}
