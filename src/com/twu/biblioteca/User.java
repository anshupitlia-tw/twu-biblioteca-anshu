package com.twu.biblioteca;

public class User {
    private UserCredentials userCredentials;

    User(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public boolean match(User accessor) {
        return true;
    }
}
