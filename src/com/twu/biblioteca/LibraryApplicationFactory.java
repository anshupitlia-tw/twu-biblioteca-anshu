package com.twu.biblioteca;

public class LibraryApplicationFactory {

    private LibraryApplication libraryApplication;

    public LibraryApplication getTheEstablishedLibraryApplication(Session session) {
        UserInterface userInterface = new UserInterfaceFactory().establishUserInterface();
        Messages messages = new MessageFactory().establishMessages();
        Library library = new LibraryFactory().establishLibrary(session);
        Users users = new UsersFactory().establishUsers();
        MainMenu mainMenu = session.buildMainMenu(library, messages, users, userInterface);
        Parser parser =  new ParserFactory().establishParser(mainMenu);
        libraryApplication = new LibraryApplication(userInterface, messages, mainMenu, parser, session, library, users);
        return libraryApplication;
    }
}
