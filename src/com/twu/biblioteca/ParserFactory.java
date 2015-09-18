package com.twu.biblioteca;

public class ParserFactory {
    private Parser parser;

    public Parser establishParser(Session session) {
        UserInterface userInterface = new UserInterfaceFactory().establishUserInterface();
        Messages messages = new MessageFactory().establishMessages();
        InvalidMenuItem invalidMenuItem = new InvalidMenuItem(userInterface, messages);
        MainMenu mainMenu = session.getCurrentUser().getMainMenu(session);
        parser = new Parser(invalidMenuItem, mainMenu);
        return parser;
    }
}
