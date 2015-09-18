package com.twu.biblioteca;

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
