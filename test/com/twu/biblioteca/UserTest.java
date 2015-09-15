package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldBeAbleToMatchAnAccessorWithItselfAndReturnTrueIfMatched() {
        User registeredUser = new User(new UserCredentials("bib-0001", "password"));
        User accessorUser = new User(new UserCredentials("bib-0001", "password"));

        assertEquals(true, registeredUser.match(accessorUser));
    }
}
