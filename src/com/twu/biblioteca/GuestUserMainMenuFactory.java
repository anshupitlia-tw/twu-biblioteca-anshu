package com.twu.biblioteca;

import java.util.LinkedHashMap;

public class GuestUserMainMenuFactory {

    public MainMenu establishMainMenu(Session session, Library library, Messages messages, Users users, UserInterface userInterface) {
        LinkedHashMap<String, MenuItem> mainMenuList = new LinkedHashMap<>();

        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(messages.getUXMessage("list_books"), userInterface, library);
        QuitMenuItem quitMenuItem = new QuitMenuItem(messages.getUXMessage("quit_option"));
        ListMoviesMenuItem listMoviesMenuItem = new ListMoviesMenuItem(messages.getUXMessage("list_movies"), userInterface, library);
        CheckoutMovieMenuItem checkoutMovieMenuItem = new CheckoutMovieMenuItem(messages.getUXMessage("checkout_movie"), library, userInterface, messages);
        LoginMenuItem loginMenuItem = new LoginMenuItem(messages.getUXMessage("login"), userInterface, users, session, messages);

        LoginCaller loginCaller = new LoginCaller(loginMenuItem, session, userInterface);

        CheckoutBookMenuItem checkoutBookMenuItem = new CheckoutBookMenuItem(messages.getUXMessage("checkout_book"), library, userInterface, loginCaller, messages);
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(messages.getUXMessage("return_book"), library, userInterface, loginCaller, messages);
        mainMenuList.put("1", listBooksMenuItem);
        mainMenuList.put("2", quitMenuItem);
        mainMenuList.put("3", checkoutBookMenuItem);
        mainMenuList.put("4", returnBookMenuItem);
        mainMenuList.put("5", listMoviesMenuItem);
        mainMenuList.put("6", checkoutMovieMenuItem);
        mainMenuList.put("7", loginMenuItem);
        MainMenu mainMenu = new MainMenu(mainMenuList);
        return mainMenu;
    }
}
