package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginCallerTest {

    @Test
    public void shouldCallLoginIfTheUserIsNotLoggedIn() {
        LoginMenuItem loginMenuItem  = mock(LoginMenuItem.class);
        Session session = mock(Session.class);
        UserInterface userInterface = mock(UserInterface.class);

        LoginCaller loginCaller = new LoginCaller(loginMenuItem, session, userInterface);
        loginCaller.callLoginViewForUser();

        verify(loginMenuItem).execute();
    }

    @Test
    public void shouldCallLoginIfTheLibrarianIsNotLoggedIn() {
        LoginMenuItem loginMenuItem  = mock(LoginMenuItem.class);
        Session session = mock(Session.class);
        UserInterface userInterface = mock(UserInterface.class);

        LoginCaller loginCaller = new LoginCaller(loginMenuItem, session, userInterface);
        loginCaller.callLoginViewForLibrarian();

        verify(loginMenuItem).execute();
    }
}
