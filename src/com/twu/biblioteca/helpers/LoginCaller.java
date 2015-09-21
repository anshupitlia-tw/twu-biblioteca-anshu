package com.twu.biblioteca.helpers;

import com.twu.biblioteca.authentication.Librarian;
import com.twu.biblioteca.authentication.Session;
import com.twu.biblioteca.authentication.User;
import com.twu.biblioteca.menu_items.LoginMenuItem;
import com.twu.biblioteca.user_interface.UserInterface;

public class LoginCaller {
    private LoginMenuItem loginMenuItem;
    private Session session;
    private UserInterface userInterface;

    public LoginCaller(LoginMenuItem loginMenuItem, Session session, UserInterface userInterface) {
        this.loginMenuItem  = loginMenuItem;
        this.session = session;
        this.userInterface = userInterface;
    }

    public boolean callLoginViewForUser() {
        if (session.getCurrentUser() instanceof User) {
            return true;
        }
        else {
            userInterface.printOnOutputStream("You need to login first");
            loginMenuItem.execute();
            if (session.getCurrentUser() instanceof User) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean callLoginViewForLibrarian() {
        if (session.getCurrentUser() instanceof Librarian) {
            return true;
        }
        else {
            userInterface.printOnOutputStream("You need to login first");
            loginMenuItem.execute();
            if (session.getCurrentUser() instanceof Librarian) {
                return true;
            } else {
                userInterface.printOnOutputStream("Invalid Credentials");
                return false;
            }
        }
    }
}
