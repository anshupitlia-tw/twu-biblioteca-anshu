package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class UserTest {

    @Test
    public void shouldBeAbleToMatchAnAccessorWithItselfAndReturnTrueIfTheAccessorIsRegisteredUser() {
        User registeredUser = new User(new UserCredentials("bib-0001", "password"), "", "", "");
        UserCredentials accessorUserCredentials = new UserCredentials("bib-0001", "password");

        assertEquals(true, registeredUser.isValidLogin(accessorUserCredentials));
    }

    @Test
    public void shouldBeAbleToMatchAnAccessorWithItselfAndReturnFalseIfTheAccessorIsNotRegisteredUser() {
        User registeredUser = new User(new UserCredentials("bib-0001", "password"), "", "", "");
        UserCredentials accessorUserCredentials = new UserCredentials("bib-0000", "password");

        assertEquals(false, registeredUser.isValidLogin(accessorUserCredentials));
    }

    @Test
    public void shouldGetMainMenu() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        UserCredentials userCredentials = mock(UserCredentials.class);
        User user = new User(userCredentials, "", "", "");

        assertEquals(MainMenu.class, user.getMainMenu(session, library, messages, users, userInterface).getClass());
    }

    @Test
    public void shouldGetHisDetailsInProperFormat() {
        User registeredUser = new User(new UserCredentials("bib-0001", "password"), "ABC XYZ", "abcxyz@mailprovider.com", "9876543210");
        StringBuilder bookDetails = new StringBuilder();
        bookDetails.append(String.format("%-40s%-40s\n%-40s%-40s\n%-40s%-40s\n", "NAME", "ABC XYZ", "EMAIL ADDRESS", "abcxyz@mailprovider.com", "PHONE NUMBER", "9876543210"));
        String expectedBookDetails = bookDetails.toString();
        assertEquals(expectedBookDetails, registeredUser.getUserDetailsInDisplayableFormat());
    }
}
