package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogoutMenuItemTest {

    @Test
    public void shouldLogoutAUser() {
        Session session = new Session(new User(new UserCredentials("1234", "1234")));
        LogoutMenuItem logoutMenuItem = new LogoutMenuItem("Logo", session);

        logoutMenuItem.execute();

        assertEquals(null, session.getCurrentUser());
    }
}
