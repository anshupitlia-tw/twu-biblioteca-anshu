package com.twu.biblioteca;

//The Bangalore Public Library Application
public class LibraryApplication {
    private UserInterface userInterface;
    private Messages messages;
    private MainMenu mainMenu;
    private Parser parser;

    public LibraryApplication(UserInterface userInterface, Messages messages, MainMenu mainMenu, Parser parser) {
        this.userInterface = userInterface;
        this.messages = messages;
        this.mainMenu = mainMenu;
        this.parser = parser;
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
}
