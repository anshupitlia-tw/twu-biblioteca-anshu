package com.twu.biblioteca.authentication;

import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class UserTest {

    @Test
    public void shouldBeAbleToMatchAnAccessorWithItselfAndReturnTrueIfTheAccessorIsRegisteredUser() {
        com.twu.biblioteca.authentication.User registeredUser = new com.twu.biblioteca.authentication.User(new com.twu.biblioteca.authentication.UserCredentials("bib-0001", "password"), "", "", "");
        com.twu.biblioteca.authentication.UserCredentials accessorUserCredentials = new com.twu.biblioteca.authentication.UserCredentials("bib-0001", "password");

        assertEquals(true, registeredUser.isValidLogin(accessorUserCredentials));
    }

    @Test
    public void shouldBeAbleToMatchAnAccessorWithItselfAndReturnFalseIfTheAccessorIsNotRegisteredUser() {
        com.twu.biblioteca.authentication.User registeredUser = new com.twu.biblioteca.authentication.User(new com.twu.biblioteca.authentication.UserCredentials("bib-0001", "password"), "", "", "");
        com.twu.biblioteca.authentication.UserCredentials accessorUserCredentials = new com.twu.biblioteca.authentication.UserCredentials("bib-0000", "password");

        assertEquals(false, registeredUser.isValidLogin(accessorUserCredentials));
    }

    @Test
    public void shouldGetMainMenu() {
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        Messages messages = mock(Messages.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        com.twu.biblioteca.authentication.UserCredentials userCredentials = mock(com.twu.biblioteca.authentication.UserCredentials.class);
        com.twu.biblioteca.authentication.User user = new com.twu.biblioteca.authentication.User(userCredentials, "", "", "");

        assertEquals(MainMenu.class, user.getMainMenu(session, library, messages, users, userInterface).getClass());
    }

    @Test
    public void shouldGetHisDetailsInProperFormat() {
        com.twu.biblioteca.authentication.User registeredUser = new com.twu.biblioteca.authentication.User(new com.twu.biblioteca.authentication.UserCredentials("bib-0001", "password"), "ABC XYZ", "abcxyz@mailprovider.com", "9876543210");
        StringBuilder bookDetails = new StringBuilder();
        bookDetails.append(String.format("%-40s%-40s\n%-40s%-40s\n%-40s%-40s\n", "NAME", "ABC XYZ", "EMAIL ADDRESS", "abcxyz@mailprovider.com", "PHONE NUMBER", "9876543210"));
        String expectedBookDetails = bookDetails.toString();
        assertEquals(expectedBookDetails, registeredUser.getUserDetailsInDisplayableFormat());
    }
}
