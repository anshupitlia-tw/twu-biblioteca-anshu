package com.twu.biblioteca;

import java.util.HashMap;

public class MainMenuFactory {

    public MainMenu establishMainMenu() {
        HashMap<Integer, MenuItem> mainMenuList = new HashMap<>();
        Messages messages = new MessageFactory().establishMessages();
        Library library = new LibraryFactory().establishLibrary();
        UserInterface userInterface = new UserInterfaceFactory().establishUserInterface();
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(messages.getUXMessage("list_books"),userInterface, library);
        QuitMenuItem quitMenuItem = new QuitMenuItem(messages.getUXMessage("quit_option"));
        CheckoutBookMenuItem checkoutBookMenuItem = new CheckoutBookMenuItem(messages.getUXMessage("checkout_book"), library, userInterface , messages);
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(messages.getUXMessage("return_book"),library, userInterface, messages);
        mainMenuList.put(1, listBooksMenuItem);
        mainMenuList.put(2, quitMenuItem);
        mainMenuList.put(3, checkoutBookMenuItem);
        mainMenuList.put(4, returnBookMenuItem);
        MainMenu mainMenu = new MainMenu(mainMenuList);
        return mainMenu;
    }
}
