package com.twu.biblioteca;

//The Bangalore Public Library Application
public class LibraryApplication {
    private UserInterface userInterface;
    private Messages messages;
    private MainMenu mainMenu;
    private Parser parser;
    private Session session;

    public LibraryApplication(UserInterface userInterface, Messages messages, MainMenu mainMenu, Parser parser, Session session) {
        this.userInterface = userInterface;
        this.messages = messages;
        this.mainMenu = mainMenu;
        this.parser = parser;
        this.session = session;
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
        MenuItem assignedMenuItem = parser.assignADelegateMenu(choice);
        assignedMenuItem.execute();
    }

    private void setMainMenu() {
        mainMenu = session.getCurrentUser().getMainMenu(session);
    }

    private void setParser() {
        parser = new ParserFactory().establishParser(session);
    }
}
