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
            choice = getUserChoice();
            executeMenu(parser, choice);
        }while(shouldGetChoiceAgain(choice, parser));
    }

    public int getUserChoice() {
        return userInterface.getMenuChoice();
    }

    public void executeMenu(Parser parser, int choice) {
        MenuItem assignedMenuItem = parser.assignADelegateMenu(choice);
        assignedMenuItem.execute();
    }

    public boolean shouldGetChoiceAgain(int choice, Parser parser) {
        return !parser.isValidMenuChoice(choice) || !parser.isQuitting(choice);
    }
}
