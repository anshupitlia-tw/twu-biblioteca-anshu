package com.twu.biblioteca.factories;

import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.menu_items.InvalidMenuItem;
import com.twu.biblioteca.parser.Parser;
import com.twu.biblioteca.user_interface.UserInterface;

public class ParserFactory {
    private Parser parser;

    public Parser establishParser(MainMenu mainMenu) {
        UserInterface userInterface = new UserInterfaceFactory().establishUserInterface();
        Messages messages = new MessageFactory().establishMessages();
        InvalidMenuItem invalidMenuItem = new InvalidMenuItem(userInterface, messages);
        parser = new Parser(invalidMenuItem, mainMenu);
        return parser;
    }
}
