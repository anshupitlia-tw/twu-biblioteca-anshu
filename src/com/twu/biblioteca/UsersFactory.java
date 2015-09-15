package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UsersFactory {
    private Users users;

    public Users establishUsers() {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User(new UserCredentials("bib-0001", "password1")));
        usersList.add(new User(new UserCredentials("bib-0002", "password2")));
        usersList.add(new User(new UserCredentials("bib-0003", "password3")));
        usersList.add(new User(new UserCredentials("bib-0004", "password4")));
        usersList.add(new User(new UserCredentials("bib-0005", "password5")));
        usersList.add(new User(new UserCredentials("bib-0006", "password6")));
        usersList.add(new User(new UserCredentials("bib-0007", "password7")));
        usersList.add(new User(new UserCredentials("bib-0008", "password8")));
        usersList.add(new User(new UserCredentials("bib-0009", "password9")));
        usersList.add(new User(new UserCredentials("bib-0010", "password10")));
        users = new Users(usersList);
        return users;
    }
}
