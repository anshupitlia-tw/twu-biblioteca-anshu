package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldBeAbleToMatchAnAccessorWithItselfAndReturnTrueIfTheAccessorIsRegisteredUser() {
        User registeredUser = new User(new UserCredentials("bib-0001", "password"));
        UserCredentials accessorUserCredentials = new UserCredentials("bib-0001", "password");

        assertEquals(true, registeredUser.isValidLogin(accessorUserCredentials));
    }

    @Test
    public void shouldBeAbleToMatchAnAccessorWithItselfAndReturnFalseIfTheAccessorIsNotRegisteredUser() {
        User registeredUser = new User(new UserCredentials("bib-0001", "password"));
        UserCredentials accessorUserCredentials = new UserCredentials("bib-0000", "password");

        assertEquals(false, registeredUser.isValidLogin(accessorUserCredentials));
    }
}
