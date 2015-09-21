package com.twu.biblioteca.menu_items;

import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.user_interface.UserInterface;

public class InvalidMenuItem extends MenuItem {
    private UserInterface userInterface;
    private Messages messages;

    public InvalidMenuItem(UserInterface userInterface, Messages messages) {
        this.userInterface = userInterface;
        this.messages = messages;
    }
    @Override
    public void execute() {
        userInterface.printOnOutputStream(messages.getUXMessage("select_a_valid_option"));
    }
}
