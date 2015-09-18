package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UsersTest {

    @Test
    public void shouldBeAbleToLoginAndBecomeTheCurrentUserIfTheirCredentialsAreCorrect() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(new UserCredentials("bib-0001", "password"), "", "", "");
        User user2 = new User(new UserCredentials("bib-0002", "password2"), "", "", "");
        userList.add(user1);
        userList.add(user2);
        Users registeredUsers = new Users(userList);
        UserCredentials accessorUserCredentials = new UserCredentials("bib-0001", "password");
        assertEquals(registeredUsers.login(accessorUserCredentials), user1);
    }
}
