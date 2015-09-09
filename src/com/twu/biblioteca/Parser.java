package com.twu.biblioteca;

public class Parser {
    private UserInterface userInterface;
    private MainMenu mainMenu;
    private Messages messages;

    Parser(UserInterface userInterface, Messages messages, MainMenu mainMenu) {
        this.userInterface = userInterface;
        this.messages = messages;
        this.mainMenu = mainMenu;
    }

    public boolean isValidMenuChoice(int choice) {
        if (mainMenu.hasMenu(choice)) {
            return true;
        } else {
            return false;
        }
    }

    public AMenu assignADelegateMenu(int choice) {
        AMenu menu = new InvalidMenu(userInterface, messages);
        if (!isValidMenuChoice(choice))
            return menu;
        return (mainMenu.getMenu(choice));
    }

    public boolean isQuitting(int choice) {
        return mainMenu.getMenu(choice).getName().equals(messages.getUXMessage("quit_option"));
    }
}
