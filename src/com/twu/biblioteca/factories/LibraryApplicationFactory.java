package com.twu.biblioteca.factories;

public class LibraryApplicationFactory {

    private com.twu.biblioteca.controller.LibraryApplication libraryApplication;

    public com.twu.biblioteca.controller.LibraryApplication getTheEstablishedLibraryApplication(com.twu.biblioteca.authentication.Session session) {
        com.twu.biblioteca.user_interface.UserInterface userInterface = new UserInterfaceFactory().establishUserInterface();
        com.twu.biblioteca.helpers.Messages messages = new MessageFactory().establishMessages();
        com.twu.biblioteca.models.Library library = new LibraryFactory().establishLibrary(session);
        com.twu.biblioteca.authentication.Users users = new UsersFactory().establishUsers();
        com.twu.biblioteca.main_menu.MainMenu mainMenu = session.buildMainMenu(library, messages, users, userInterface);
        com.twu.biblioteca.parser.Parser parser =  new ParserFactory().establishParser(mainMenu);
        libraryApplication = new com.twu.biblioteca.controller.LibraryApplication(userInterface, messages, mainMenu, parser, session, library, users);
        return libraryApplication;
    }
}
