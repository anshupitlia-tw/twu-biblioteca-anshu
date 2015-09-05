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
    public void listBooks() {
        userInterface.print(library.getBookListForDisplay());
    }
}
