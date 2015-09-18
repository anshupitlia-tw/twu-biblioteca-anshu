package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UsersFactory {
    private Users users;

    public Users establishUsers() {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User(new UserCredentials("bib-0001", "password1"), "User 1", "user1@mailprovider.com", "1111111111"));
        usersList.add(new User(new UserCredentials("bib-0002", "password2"), "User 2", "user2@mailprovider.com", "2222222222"));
        usersList.add(new User(new UserCredentials("bib-0003", "password3"), "User 3", "user3@mailprovider.com", "3333333333"));
        usersList.add(new User(new UserCredentials("bib-0004", "password4"), "User 4", "user4@mailprovider.com", "4444444444"));
        usersList.add(new User(new UserCredentials("bib-0005", "password5"), "User 5", "user5@mailprovider.com", "5555555555"));
        usersList.add(new User(new UserCredentials("bib-0006", "password6"), "User 6", "user6@mailprovider.com", "6666666666"));
        usersList.add(new User(new UserCredentials("bib-0007", "password7"), "User 7", "user7@mailprovider.com", "7777777777"));
        usersList.add(new User(new UserCredentials("bib-0008", "password8"), "User 8", "user8@mailprovider.com", "8888888888"));
        usersList.add(new User(new UserCredentials("bib-0009", "password9"), "User 9", "user9@mailprovider.com", "9999999999"));
        usersList.add(new User(new UserCredentials("bib-0010", "password10"), "User 10", "user10@mailprovider.com", "1010101010"));

        usersList.add(new Librarian(new UserCredentials("lib-0001", "password1"), "Librarian 1", "lib1@mailprovider.com", "9876543210"));
        usersList.add(new Librarian(new UserCredentials("lib-0002", "password2"), "Librarian 2", "lib2@mailprovider.com", "1234567890"));
        users = new Users(usersList);
        return users;
    }
}
