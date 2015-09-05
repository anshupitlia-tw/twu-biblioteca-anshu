package com.twu.biblioteca;

//The Bangalore Public Library Application
public class LibraryApplication {
    private UserInterface userInterface;
    private Messages messages;
    private Library library;
    private MainMenu mainMenu;

    public LibraryApplication(UserInterface userInterface, Messages messages, Library library, MainMenu mainMenu) {
        this.userInterface = userInterface;
        this.messages = messages;
        this.library = library;
        this.mainMenu = mainMenu;
    }

    public void start() {
        userInterface.print(messages.getUXMessage("welcome_message"));
    }

    public void listMainMenu() {
        userInterface.print(mainMenu.getListOfMenuForDisplay());
    }

    public int getUserChoice() {
        int choice;
            choice = userInterface.getMenuChoice();
            if (!mainMenu.hasMenu(choice)) {
                userInterface.print(messages.getUXMessage("select_a_valid_option"));
                choice = 1;
            }
        return choice;
    }

    public void parse(int choice) {
        if (mainMenu.getMenu(choice).equals(messages.getUXMessage("list_books"))) {
              listBooks();
        }
    }

    private void listBooks() {
        userInterface.print(library.getBookListForDisplay());
    }
}
