package com.twu.biblioteca.authentication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SessionTest {

    @Test
    public void shouldBeAbleToGiveTheCurrentlyLoggedInUser() {
        com.twu.biblioteca.authentication.User currentUser = new com.twu.biblioteca.authentication.User(new com.twu.biblioteca.authentication.UserCredentials("bib-0001", "password"), "", "", "");
        com.twu.biblioteca.authentication.Session session = new com.twu.biblioteca.authentication.Session(currentUser);

        assertEquals(currentUser, session.getCurrentUser());
    }
}
