package com.twu.biblioteca;

public class User {
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
}
