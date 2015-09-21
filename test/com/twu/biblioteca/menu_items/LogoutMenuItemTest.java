package com.twu.biblioteca.menu_items;

import com.twu.biblioteca.authentication.Guest;
import com.twu.biblioteca.authentication.Session;
import com.twu.biblioteca.authentication.User;
import com.twu.biblioteca.authentication.UserCredentials;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogoutMenuItemTest {

    @Test
    public void shouldLogoutAUserAndMakeHimAGuest() {
        Session session = new Session(new User(new UserCredentials("1234", "1234"), "", "", ""));
        LogoutMenuItem logoutMenuItem = new LogoutMenuItem("Logout", session);

        logoutMenuItem.execute();

        assertEquals(Guest.class, session.getCurrentUser().getClass());
    }
}
