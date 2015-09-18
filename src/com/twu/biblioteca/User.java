package com.twu.biblioteca;

public class User extends Guest{
    private UserCredentials userCredentials;

    User(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public boolean isValidLogin(UserCredentials accessorCredentials) {
        if (this.userCredentials.equals(accessorCredentials))
            return true;
        else
            return false;
    }

    public String getLibraryNumber() {
        return userCredentials.getLibraryNumber();
    }

    @Override
    public MainMenu getMainMenu(Session session) {
        return new LoggedInUserMainMenuFactory().establishMainMenu(session);
    }
}
