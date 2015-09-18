package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginMenuItemTest {

    @Test
    public void shouldBeAbleToLoginAUserAndStoreThatInSessionAsCurrentUser() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        Session session = mock(Session.class);
        LoginMenuItem loginMenuItem = new LoginMenuItem("Login", userInterface, users, session, messages);
        UserCredentials userCredentials = new UserCredentials("bib-0001", "password");
        Guest user = new User(userCredentials);
        when(messages.getUXMessage("enter_library_number")).thenReturn("Enter library number");
        when(messages.getUXMessage("enter_password")).thenReturn("Enter password");
        when(userInterface.getChoiceFromUser()).thenReturn("bib-0001").thenReturn("password");
        when(users.login(userCredentials)).thenReturn(user);
        loginMenuItem.execute();
        verify(session).putCurrentUser(user);
    }

    @Test
    public void shouldNotBeAbleToLoginAGuestUserAndMarkInvalidCredentialsIfThatCase() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        Session session = mock(Session.class);
        LoginMenuItem loginMenuItem = new LoginMenuItem("Login", userInterface, users, session, messages);
        UserCredentials userCredentials = new UserCredentials("bib-0001", "password");
        Guest user = new Guest();
        when(messages.getUXMessage("enter_library_number")).thenReturn("Enter library number");
        when(messages.getUXMessage("enter_password")).thenReturn("Enter password");
        when(userInterface.getChoiceFromUser()).thenReturn("bib-0001").thenReturn("password");
        when(users.login(userCredentials)).thenReturn(user);
        loginMenuItem.execute();

        verify(userInterface).printOnOutputStream("Invalid Credentials");
        verify(session).putCurrentUser(user);
    }
}
