package com.twu.biblioteca.authentication;

import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class GuestTest {

    @Test
    public void shouldGetMainMenu() {
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        Messages messages = mock(Messages.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);
        UserInterface userInterface = mock(UserInterface.class);

        com.twu.biblioteca.authentication.Guest guest = new com.twu.biblioteca.authentication.Guest();

        assertEquals(MainMenu.class, guest.getMainMenu(session, library, messages, users, userInterface).getClass());
    }
}
