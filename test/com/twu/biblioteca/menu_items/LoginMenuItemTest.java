package com.twu.biblioteca.menu_items;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginMenuItemTest {

    @Test
    public void shouldBeAbleToLoginAUserAndStoreThatInSessionAsCurrentUser() {
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.menu_items.LoginMenuItem loginMenuItem = new com.twu.biblioteca.menu_items.LoginMenuItem("Login", userInterface, users, session, messages);
        com.twu.biblioteca.authentication.UserCredentials userCredentials = new com.twu.biblioteca.authentication.UserCredentials("bib-0001", "password");
        com.twu.biblioteca.authentication.Guest user = new com.twu.biblioteca.authentication.User(userCredentials, "", "", "");
        when(messages.getUXMessage("enter_library_number")).thenReturn("Enter library number");
        when(messages.getUXMessage("enter_password")).thenReturn("Enter password");
        when(userInterface.getChoiceFromUser()).thenReturn("bib-0001").thenReturn("password");
        when(users.login(userCredentials)).thenReturn(user);
        loginMenuItem.execute();
        verify(session).putCurrentUser(user);
    }

    @Test
    public void shouldNotBeAbleToLoginAGuestUserAndMarkInvalidCredentialsIfThatCase() {
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.menu_items.LoginMenuItem loginMenuItem = new com.twu.biblioteca.menu_items.LoginMenuItem("Login", userInterface, users, session, messages);
        com.twu.biblioteca.authentication.UserCredentials userCredentials = new com.twu.biblioteca.authentication.UserCredentials("bib-0001", "password");
        com.twu.biblioteca.authentication.Guest user = new com.twu.biblioteca.authentication.Guest();
        when(messages.getUXMessage("enter_library_number")).thenReturn("Enter library number");
        when(messages.getUXMessage("enter_password")).thenReturn("Enter password");
        when(userInterface.getChoiceFromUser()).thenReturn("bib-0001").thenReturn("password");
        when(users.login(userCredentials)).thenReturn(user);
        loginMenuItem.execute();

        verify(userInterface).printOnOutputStream("Invalid Credentials");
        verify(session).putCurrentUser(user);
    }
}
