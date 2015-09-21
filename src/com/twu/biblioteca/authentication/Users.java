package com.twu.biblioteca.authentication;

import java.util.List;

public class Users {
    private List<com.twu.biblioteca.authentication.User> users;

    public Users(List<com.twu.biblioteca.authentication.User> users) {
        this.users = users;
    }

    public com.twu.biblioteca.authentication.Guest login(UserCredentials accessorUserCredentials) {
        for (com.twu.biblioteca.authentication.User registeredUser: users) {
            if (registeredUser.isValidLogin(accessorUserCredentials)) {
                return registeredUser;
            }
        }
        return new com.twu.biblioteca.authentication.Guest();
    }
}
