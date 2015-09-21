package com.twu.biblioteca.helpers;

import com.twu.biblioteca.user_interface.UserInterface;

public class LoginCaller {
    private com.twu.biblioteca.menu_items.LoginMenuItem loginMenuItem;
    private com.twu.biblioteca.authentication.Session session;
    private UserInterface userInterface;

    public LoginCaller(com.twu.biblioteca.menu_items.LoginMenuItem loginMenuItem, com.twu.biblioteca.authentication.Session session, UserInterface userInterface) {
        this.loginMenuItem  = loginMenuItem;
        this.session = session;
        this.userInterface = userInterface;
    }

    public boolean callLoginViewForUser() {
        if (session.getCurrentUser() instanceof com.twu.biblioteca.authentication.User) {
            return true;
        }
        else {
            userInterface.printOnOutputStream("You need to login first");
            loginMenuItem.execute();
            if (session.getCurrentUser() instanceof com.twu.biblioteca.authentication.User) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean callLoginViewForLibrarian() {
        if (session.getCurrentUser() instanceof com.twu.biblioteca.authentication.Librarian) {
            return true;
        }
        else {
            userInterface.printOnOutputStream("You need to login first");
            loginMenuItem.execute();
            if (session.getCurrentUser() instanceof com.twu.biblioteca.authentication.Librarian) {
                return true;
            } else {
                userInterface.printOnOutputStream("Invalid Credentials");
                return false;
            }
        }
    }
}
