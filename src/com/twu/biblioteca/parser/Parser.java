package com.twu.biblioteca.parser;

public class Parser {
    private com.twu.biblioteca.menu_items.InvalidMenuItem invalidMenuItem;
    private com.twu.biblioteca.main_menu.MainMenu mainMenu;

    public Parser(com.twu.biblioteca.menu_items.InvalidMenuItem invalidMenuItem, com.twu.biblioteca.main_menu.MainMenu mainMenu) {
        this.invalidMenuItem = invalidMenuItem;
        this.mainMenu = mainMenu;
    }

    public boolean isValidMenuChoice(String choice) {
        if (mainMenu.hasMenu(choice)) {
            return true;
        } else {
            return false;
        }
    }

    public com.twu.biblioteca.menu_items.MenuItem assignADelegateMenu(String choice) {
        com.twu.biblioteca.menu_items.MenuItem menuItem = invalidMenuItem;
        if (!isValidMenuChoice(choice))
            return menuItem;
        return (mainMenu.getMenu(choice));
    }

    public boolean isQuitting(String choice) {
        return mainMenu.getMenu(choice).getClass().equals(com.twu.biblioteca.menu_items.QuitMenuItem.class);
    }

    public boolean isNotTheEndOfParsing(String choice) {
        return !isValidMenuChoice(choice) || !isQuitting(choice);
    }
}
