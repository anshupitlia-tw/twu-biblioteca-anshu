package com.twu.biblioteca;

//The Bangalore Public Library Application
public class LibraryApplication {
    private UserInterface userInterface;
    private Messages messages;
    private MainMenu mainMenu;
    private Parser parser;

    public LibraryApplication(UserInterface userInterface, Messages messages, MainMenu mainMenu) {
        this.userInterface = userInterface;
        this.messages = messages;
        this.mainMenu = mainMenu;
    }

    public void start() {
        userInterface.print(messages.getUXMessage("welcome_message"));
    }

    public void listMainMenu() {
        userInterface.print(mainMenu.getListOfMenuForDisplay());
    }

    public void controlUserChoice() {
        int choice;
        Parser parser = new Parser(userInterface, messages, mainMenu);
        do {
            choice = getUserChoice();
            executeMenu(parser, choice);
        }while(shouldGetChoiceAgain(choice, parser));
    }

    public int getUserChoice() {
        int choice;
        choice = userInterface.getMenuChoice();
        return choice;
    }

    public void executeMenu(Parser parser, int choice) {
        AMenu assignedMenu = parser.assignADelegateMenu(choice);
        assignedMenu.execute();
    }

    public boolean shouldGetChoiceAgain(int choice, Parser parser) {
        return !parser.isValidMenuChoice(choice) || !parser.isQuitting(choice);
    }
}
