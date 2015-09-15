package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserCredentialsTest {

    @Test
    public void shouldReturnTrueForValidCredentials() {
        UserCredentials userCredentials = new UserCredentials("bib-0001", "password");

        assertEquals(true, userCredentials.areValidCredentials("bib-0001", "password"));
    }

    @Test
    public void shouldReturnFalseIfWrongPasswordForALibraryNumber() {
        UserCredentials userCredentials = new UserCredentials("bib-0001", "password");

        assertEquals(false, userCredentials.areValidCredentials("bib-0001", "passwrd"));
    }

    @Test
    public void shouldReturnFalseIfWrongLibraryNumber() {
        UserCredentials userCredentials = new UserCredentials("bib-0001", "password");

        assertEquals(false, userCredentials.areValidCredentials("bib-0000", "password"));
    }
}
