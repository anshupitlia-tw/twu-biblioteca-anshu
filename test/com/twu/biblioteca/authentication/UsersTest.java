package com.twu.biblioteca.authentication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UsersTest {

    @Test
    public void shouldBeAbleToLoginAndBecomeTheCurrentUserIfTheirCredentialsAreCorrect() {
        List<com.twu.biblioteca.authentication.User> userList = new ArrayList<>();
        com.twu.biblioteca.authentication.User user1 = new com.twu.biblioteca.authentication.User(new com.twu.biblioteca.authentication.UserCredentials("bib-0001", "password"), "", "", "");
        com.twu.biblioteca.authentication.User user2 = new com.twu.biblioteca.authentication.User(new com.twu.biblioteca.authentication.UserCredentials("bib-0002", "password2"), "", "", "");
        userList.add(user1);
        userList.add(user2);
        com.twu.biblioteca.authentication.Users registeredUsers = new com.twu.biblioteca.authentication.Users(userList);
        com.twu.biblioteca.authentication.UserCredentials accessorUserCredentials = new com.twu.biblioteca.authentication.UserCredentials("bib-0001", "password");
        assertEquals(registeredUsers.login(accessorUserCredentials), user1);
    }
}
