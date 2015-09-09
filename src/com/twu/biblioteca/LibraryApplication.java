package com.twu.biblioteca;

//The Bangalore Public Library Application
public class LibraryApplication {
    private UserInterface userInterface;
    private Messages messages;
    private MainMenu mainMenu;

    public LibraryApplication(UserInterface userInterface, Messages messages, Library library, MainMenu mainMenu) {
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

    public void controlUserChoiceAndExecution() {
        int choice;
        Parser parser = new Parser(userInterface, messages, mainMenu);
        do {
            choice = getChoiceAndExecute(parser);
        }while(shouldGetChoiceAgain(choice, parser));
    }

    public int getChoiceAndExecute(Parser parser) {
        int choice;
        choice = userInterface.getMenuChoice();
        executeMenu(parser, choice);
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
