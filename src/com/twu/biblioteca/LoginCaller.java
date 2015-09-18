package com.twu.biblioteca;

public class LoginCaller {
    private LoginMenuItem loginMenuItem;
    private Session session;
    private UserInterface userInterface;

    LoginCaller(LoginMenuItem loginMenuItem, Session session, UserInterface userInterface) {
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
            if (session.getCurrentUser() instanceof  User) {
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
