package com.twu.biblioteca;

public class Parser {
    private InvalidMenuItem invalidMenuItem;
    private MainMenu mainMenu;

    Parser(InvalidMenuItem invalidMenuItem, MainMenu mainMenu) {
        this.invalidMenuItem = invalidMenuItem;
        this.mainMenu = mainMenu;
    }

    public boolean isValidMenuChoice(int choice) {
        if (mainMenu.hasMenu(choice)) {
            return true;
        } else {
            return false;
        }
    }

    public MenuItem assignADelegateMenu(int choice) {
        MenuItem menuItem = invalidMenuItem;
        if (!isValidMenuChoice(choice))
            return menuItem;
        return (mainMenu.getMenu(choice));
    }

    public boolean isQuitting(int choice) {
        return mainMenu.getMenu(choice).getClass().equals(QuitMenuItem.class);
    }

    public boolean isNotTheEndOfParsing(int choice) {
        return !isValidMenuChoice(choice) || !isQuitting(choice);
    }
}
