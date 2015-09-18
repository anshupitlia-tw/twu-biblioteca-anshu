package com.twu.biblioteca;

import java.util.List;

public class Users {
    private List<User> users;

    Users(List<User> users) {
        this.users = users;
    }

    public Guest login(UserCredentials accessorUserCredentials) {
        for (User registeredUser: users) {
            if (registeredUser.isValidLogin(accessorUserCredentials)) {
                return registeredUser;
            }
        }
        return new Guest();
    }
}
