package com.twu.biblioteca;

public class UserCredentials {
    private String libraryNumber;
    private String password;

    UserCredentials(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean areValidCredentials(String libraryNumber, String password) {
        return true;
    }
}
