package com.twu.biblioteca.helpers;

import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginCallerTest {

    @Test
    public void shouldCallLoginIfTheUserIsNotLoggedIn() {
        com.twu.biblioteca.menu_items.LoginMenuItem loginMenuItem  = mock(com.twu.biblioteca.menu_items.LoginMenuItem.class);
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        UserInterface userInterface = mock(UserInterface.class);

        com.twu.biblioteca.helpers.LoginCaller loginCaller = new com.twu.biblioteca.helpers.LoginCaller(loginMenuItem, session, userInterface);
        loginCaller.callLoginViewForUser();

        verify(loginMenuItem).execute();
    }

    @Test
    public void shouldCallLoginIfTheLibrarianIsNotLoggedIn() {
        com.twu.biblioteca.menu_items.LoginMenuItem loginMenuItem  = mock(com.twu.biblioteca.menu_items.LoginMenuItem.class);
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        UserInterface userInterface = mock(UserInterface.class);

        com.twu.biblioteca.helpers.LoginCaller loginCaller = new com.twu.biblioteca.helpers.LoginCaller(loginMenuItem, session, userInterface);
        loginCaller.callLoginViewForLibrarian();

        verify(loginMenuItem).execute();
    }
}
