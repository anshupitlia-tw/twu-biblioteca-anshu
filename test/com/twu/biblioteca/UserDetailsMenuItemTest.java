package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class UserDetailsMenuItemTest {

    @Test
    public void shouldDisplayUserDetails() {
        Session session = mock(Session.class);
        User user = mock(User.class);
        UserInterface userInterface = mock(UserInterface.class);
        LoginCaller loginCaller = mock(LoginCaller.class);
        when(session.getCurrentUser()).thenReturn(user);

        UserDetailsMenuItem userDetailsMenuItem = new UserDetailsMenuItem("View Details", session, userInterface, loginCaller);

        when(user.getUserDetailsInDisplayableFormat()).thenReturn("DETAILS");
        when(loginCaller.callLoginViewForUser()).thenReturn(true);

        userDetailsMenuItem.execute();
        verify(userInterface).printOnOutputStream("DETAILS");
    }

    @Test
    public void shouldNotDisplayUserDetailsIfTheUserIsAGuest() {
        Session session = mock(Session.class);
        User user = mock(User.class);
        UserInterface userInterface = mock(UserInterface.class);
        LoginCaller loginCaller = mock(LoginCaller.class);
        when(session.getCurrentUser()).thenReturn(user);

        UserDetailsMenuItem userDetailsMenuItem = new UserDetailsMenuItem("View Details", session, userInterface, loginCaller);

        when(loginCaller.callLoginViewForUser()).thenReturn(false);

        userDetailsMenuItem.execute();
        verify(userInterface, times(0)).printOnOutputStream("DETAILS");
    }
}
