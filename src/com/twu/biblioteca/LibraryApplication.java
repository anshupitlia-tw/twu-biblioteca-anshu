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
        userInterface.print(messages.getUXMessage("welcome_message"));
    }

    public void listMainMenu() {
        userInterface.print(mainMenu.getListOfMenuForDisplay());
    }

    public void controlUserChoice() {
        int choice;
        do {
            mainMenu.getListOfMenuForDisplay();
            choice = getUserChoice();
            executeMenu(choice);
        }while(parser.isNotTheEndOfParsing(choice));
    }

    public int getUserChoice() {
        return userInterface.getANumberFromUser();
    }

    public void executeMenu(int choice) {
        MenuItem assignedMenuItem = parser.assignADelegateMenu(choice);
        assignedMenuItem.execute();
    }
}
