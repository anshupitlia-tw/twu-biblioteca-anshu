package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LibraryApplicationFactory {

    private LibraryApplication libraryApplication;

    public LibraryApplication getTheEstablishedLibrary() {
        UserInterface userInterface = new UserInterfaceFactory().establishUserInterface();
        Messages messages = new MessageFactory().establishMessages();
        MainMenu mainMenu = new MainMenuFactory().establishMainMenu();
        Parser parser =  new ParserFactory().establishParser();
         libraryApplication = new LibraryApplication(userInterface, messages, mainMenu, parser);
        return libraryApplication;
    }
}
