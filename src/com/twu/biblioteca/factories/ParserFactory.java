package com.twu.biblioteca.factories;

public class ParserFactory {
    private com.twu.biblioteca.parser.Parser parser;

    public com.twu.biblioteca.parser.Parser establishParser(com.twu.biblioteca.main_menu.MainMenu mainMenu) {
        com.twu.biblioteca.user_interface.UserInterface userInterface = new UserInterfaceFactory().establishUserInterface();
        com.twu.biblioteca.helpers.Messages messages = new com.twu.biblioteca.factories.MessageFactory().establishMessages();
        com.twu.biblioteca.menu_items.InvalidMenuItem invalidMenuItem = new com.twu.biblioteca.menu_items.InvalidMenuItem(userInterface, messages);
        parser = new com.twu.biblioteca.parser.Parser(invalidMenuItem, mainMenu);
        return parser;
    }
}
