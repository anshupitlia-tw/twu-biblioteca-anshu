
package com.twu.biblioteca.factories;

import com.twu.biblioteca.authentication.Session;
import com.twu.biblioteca.authentication.Users;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.user_interface.UserInterface;

import java.util.LinkedHashMap;

public class LibrarianMainMenuFactory {
    public MainMenu establishMainMenu(Session session, Library library, Messages messages, Users users, UserInterface userInterface) {
        LinkedHashMap<String, com.twu.biblioteca.menu_items.MenuItem> mainMenuList = new LinkedHashMap<>();

        com.twu.biblioteca.menu_items.ListBooksMenuItem listBooksMenuItem = new com.twu.biblioteca.menu_items.ListBooksMenuItem(messages.getUXMessage("list_books"), userInterface, library);
        com.twu.biblioteca.menu_items.QuitMenuItem quitMenuItem = new com.twu.biblioteca.menu_items.QuitMenuItem(messages.getUXMessage("quit_option"));
        com.twu.biblioteca.menu_items.ListMoviesMenuItem listMoviesMenuItem = new com.twu.biblioteca.menu_items.ListMoviesMenuItem(messages.getUXMessage("list_movies"), userInterface, library);
        com.twu.biblioteca.menu_items.CheckoutMovieMenuItem checkoutMovieMenuItem = new com.twu.biblioteca.menu_items.CheckoutMovieMenuItem(messages.getUXMessage("checkout_movie"), library, userInterface, messages);
        com.twu.biblioteca.menu_items.LoginMenuItem loginMenuItem = new com.twu.biblioteca.menu_items.LoginMenuItem(messages.getUXMessage("login"), userInterface, users, session, messages);
        com.twu.biblioteca.menu_items.LogoutMenuItem logoutMenuItem = new com.twu.biblioteca.menu_items.LogoutMenuItem(messages.getUXMessage("logout"), session);
        com.twu.biblioteca.helpers.LoginCaller loginCaller = new com.twu.biblioteca.helpers.LoginCaller(loginMenuItem, session, userInterface);
        com.twu.biblioteca.menu_items.CheckoutBookMenuItem checkoutBookMenuItem = new com.twu.biblioteca.menu_items.CheckoutBookMenuItem(messages.getUXMessage("checkout_book"), library, userInterface, loginCaller, messages);
        com.twu.biblioteca.menu_items.ReturnBookMenuItem returnBookMenuItem = new com.twu.biblioteca.menu_items.ReturnBookMenuItem(messages.getUXMessage("return_book"),library, userInterface, loginCaller, messages);
        com.twu.biblioteca.menu_items.CheckedOutBookDetailsMenuItem checkedOutBookDetailsMenuItem = new com.twu.biblioteca.menu_items.CheckedOutBookDetailsMenuItem("Checked Out Book Details", userInterface, library, loginCaller);
        com.twu.biblioteca.menu_items.UserDetailsMenuItem userDetailsMenuItem = new com.twu.biblioteca.menu_items.UserDetailsMenuItem(messages.getUXMessage("view_user_profile"), session, userInterface, loginCaller);

        mainMenuList.put("1", listBooksMenuItem);
        mainMenuList.put("2", quitMenuItem);
        mainMenuList.put("3", checkoutBookMenuItem);
        mainMenuList.put("4", returnBookMenuItem);
        mainMenuList.put("5", listMoviesMenuItem);
        mainMenuList.put("6", checkoutMovieMenuItem);
        mainMenuList.put("7", logoutMenuItem);
        mainMenuList.put("8", checkedOutBookDetailsMenuItem);
        mainMenuList.put("9", userDetailsMenuItem);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = new com.twu.biblioteca.main_menu.MainMenu(mainMenuList);
        return mainMenu;
    }
}

