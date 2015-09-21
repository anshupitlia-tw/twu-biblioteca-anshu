package com.twu.biblioteca.controller;

import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.parser.Parser;
import com.twu.biblioteca.user_interface.UserInterface;

//The Bangalore Public Library Application
public class LibraryApplication {
    private UserInterface userInterface;
    private com.twu.biblioteca.helpers.Messages messages;
    private MainMenu mainMenu;
    private Parser parser;
    private com.twu.biblioteca.authentication.Session session;
    private com.twu.biblioteca.models.Library library;
    private com.twu.biblioteca.authentication.Users users;

    public LibraryApplication(UserInterface userInterface, com.twu.biblioteca.helpers.Messages messages, MainMenu mainMenu, Parser parser, com.twu.biblioteca.authentication.Session session, com.twu.biblioteca.models.Library library, com.twu.biblioteca.authentication.Users users) {
        this.userInterface = userInterface;
        this.messages = messages;
        this.mainMenu = mainMenu;
        this.parser = parser;
        this.session = session;
        this.library = library;
        this.users = users;
    }

    public void start() {
        userInterface.printOnOutputStream(messages.getUXMessage("welcome_message"));
    }

    public void listMainMenu() {
        userInterface.printOnOutputStream(mainMenu.getListOfMenuForDisplay());
    }

    public void controlUserChoice() {
        String choice;
        do {
            setMainMenu();
            setParser();
            listMainMenu();
            choice = getUserChoice();
            executeMenu(choice);
        }while(parser.isNotTheEndOfParsing(choice));
    }

    public String getUserChoice() {
        return userInterface.getChoiceFromUser();
    }

    public void executeMenu(String choice) {
        com.twu.biblioteca.menu_items.MenuItem assignedMenuItem = parser.assignADelegateMenu(choice);
        assignedMenuItem.execute();
    }

    private void setMainMenu() {
        mainMenu = session.buildMainMenu(library, messages, users, userInterface);
    }

    private void setParser() {
        parser = new com.twu.biblioteca.factories.ParserFactory().establishParser(mainMenu);
    }
}
