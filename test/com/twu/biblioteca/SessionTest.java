package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SessionTest {

    @Test
    public void shouldBeAbleToGiveTheCurrentlyLoggedInUser() {
        User currentUser = new User(new UserCredentials("bib-0001", "password"), "", "", "");
        Session session = new Session(currentUser);

        assertEquals(currentUser, session.getCurrentUser());
    }
}
