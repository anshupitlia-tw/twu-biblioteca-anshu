package com.twu.biblioteca;

public class LibraryApplicationFactory {

    private LibraryApplication libraryApplication;

    public LibraryApplication getTheEstablishedLibraryApplication(Session session) {
        UserInterface userInterface = new UserInterfaceFactory().establishUserInterface();
        Messages messages = new MessageFactory().establishMessages();
        MainMenu mainMenu = session.getCurrentUser().getMainMenu(session);
        Parser parser =  new ParserFactory().establishParser(session);
        libraryApplication = new LibraryApplication(userInterface, messages, mainMenu, parser, session);
        return libraryApplication;
    }
}
