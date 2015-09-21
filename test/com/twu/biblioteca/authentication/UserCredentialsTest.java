package com.twu.biblioteca.authentication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserCredentialsTest {

    @Test
    public void shouldReturnTrueForValidCredentials() {
        com.twu.biblioteca.authentication.UserCredentials registeredUserCredentials = new com.twu.biblioteca.authentication.UserCredentials("bib-0001", "password");
        com.twu.biblioteca.authentication.UserCredentials accessorUserCredentials = new com.twu.biblioteca.authentication.UserCredentials("bib-0001", "password");

        assertEquals(true, registeredUserCredentials.equals(accessorUserCredentials));
    }

    @Test
    public void shouldReturnFalseIfWrongPasswordForALibraryNumber() {
        com.twu.biblioteca.authentication.UserCredentials registeredUserCredentials = new com.twu.biblioteca.authentication.UserCredentials("bib-0001", "password");

        assertEquals(false, registeredUserCredentials.equals(new com.twu.biblioteca.authentication.UserCredentials("bib-0001", "passwrd")));
    }

    @Test
    public void shouldReturnFalseIfWrongLibraryNumber() {
        com.twu.biblioteca.authentication.UserCredentials registeredUserCredentials = new com.twu.biblioteca.authentication.UserCredentials("bib-0001", "password");

        assertEquals(false, registeredUserCredentials.equals(new com.twu.biblioteca.authentication.UserCredentials("bib-0000", "password")));
    }
}
