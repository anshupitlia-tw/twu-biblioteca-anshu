package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserCredentialsTest {

    @Test
    public void shouldReturnTrueForValidCredentials() {
        UserCredentials registeredUserCredentials = new UserCredentials("bib-0001", "password");
        UserCredentials accessorUserCredentials = new UserCredentials("bib-0001", "password");

        assertEquals(true, registeredUserCredentials.equals(accessorUserCredentials));
    }

    @Test
    public void shouldReturnFalseIfWrongPasswordForALibraryNumber() {
        UserCredentials registeredUserCredentials = new UserCredentials("bib-0001", "password");

        assertEquals(false, registeredUserCredentials.equals(new UserCredentials("bib-0001", "passwrd")));
    }

    @Test
    public void shouldReturnFalseIfWrongLibraryNumber() {
        UserCredentials registeredUserCredentials = new UserCredentials("bib-0001", "password");

        assertEquals(false, registeredUserCredentials.equals(new UserCredentials("bib-0000", "password")));
    }
}
