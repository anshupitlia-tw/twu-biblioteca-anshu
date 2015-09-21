package com.twu.biblioteca.parser;

import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.menu_items.InvalidMenuItem;
import com.twu.biblioteca.menu_items.MenuItem;
import com.twu.biblioteca.menu_items.QuitMenuItem;

public class Parser {
    private InvalidMenuItem invalidMenuItem;
    private MainMenu mainMenu;

    public Parser(InvalidMenuItem invalidMenuItem, MainMenu mainMenu) {
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

    public MenuItem assignADelegateMenu(String choice) {
        MenuItem menuItem = invalidMenuItem;
        if (!isValidMenuChoice(choice))
            return menuItem;
        return (mainMenu.getMenu(choice));
    }

    public boolean isQuitting(String choice) {
        return mainMenu.getMenu(choice).getClass().equals(QuitMenuItem.class);
    }

    public boolean isNotTheEndOfParsing(String choice) {
        return !isValidMenuChoice(choice) || !isQuitting(choice);
    }
}
