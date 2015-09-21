package com.twu.biblioteca.authentication;

import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class LibrarianTest {

    @Test
    public void shouldGetMainMenu() {
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        Messages messages = mock(Messages.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        com.twu.biblioteca.authentication.UserCredentials userCredentials = mock(com.twu.biblioteca.authentication.UserCredentials.class);
        com.twu.biblioteca.authentication.Librarian librarian = new com.twu.biblioteca.authentication.Librarian(userCredentials, "", "", "");

        assertEquals(MainMenu.class, librarian.getMainMenu(session, library, messages, users, userInterface).getClass());
    }
}
