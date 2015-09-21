package com.twu.biblioteca.factories;

import com.twu.biblioteca.authentication.Session;
import com.twu.biblioteca.authentication.Users;
import com.twu.biblioteca.controller.LibraryApplication;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.parser.Parser;
import com.twu.biblioteca.user_interface.UserInterface;

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
