
package com.twu.biblioteca.factories;

import com.twu.biblioteca.authentication.Session;
import com.twu.biblioteca.authentication.Users;
import com.twu.biblioteca.helpers.LoginCaller;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.menu_items.*;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.user_interface.UserInterface;

import java.util.LinkedHashMap;

public class LoggedInUserMainMenuFactory {
    public MainMenu establishMainMenu(Session session, Library library, Messages messages, Users users, UserInterface userInterface) {
        LinkedHashMap<String, MenuItem> mainMenuList = new LinkedHashMap<>();

        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(messages.getUXMessage("list_books"), userInterface, library);
        QuitMenuItem quitMenuItem = new QuitMenuItem(messages.getUXMessage("quit_option"));
        ListMoviesMenuItem listMoviesMenuItem = new ListMoviesMenuItem(messages.getUXMessage("list_movies"), userInterface, library);
        CheckoutMovieMenuItem checkoutMovieMenuItem = new CheckoutMovieMenuItem(messages.getUXMessage("checkout_movie"), library, userInterface, messages);
        LoginMenuItem loginMenuItem = new LoginMenuItem(messages.getUXMessage("login"), userInterface, users, session, messages);
        LogoutMenuItem logoutMenuItem = new LogoutMenuItem(messages.getUXMessage("logout"), session);
        LoginCaller loginCaller = new LoginCaller(loginMenuItem, session, userInterface);

        CheckoutBookMenuItem checkoutBookMenuItem = new CheckoutBookMenuItem(messages.getUXMessage("checkout_book"), library, userInterface, loginCaller, messages);
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(messages.getUXMessage("return_book"),library, userInterface, loginCaller, messages);
        UserDetailsMenuItem userDetailsMenuItem = new UserDetailsMenuItem(messages.getUXMessage("view_user_profile"), session, userInterface, loginCaller);

        mainMenuList.put("1", listBooksMenuItem);
        mainMenuList.put("2", quitMenuItem);
        mainMenuList.put("3", checkoutBookMenuItem);
        mainMenuList.put("4", returnBookMenuItem);
        mainMenuList.put("5", listMoviesMenuItem);
        mainMenuList.put("6", checkoutMovieMenuItem);
        mainMenuList.put("7", logoutMenuItem);
        mainMenuList.put("8", userDetailsMenuItem);
        MainMenu mainMenu = new MainMenu(mainMenuList);
        return mainMenu;
    }
}

