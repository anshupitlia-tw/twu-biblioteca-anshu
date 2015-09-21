package com.twu.biblioteca.authentication;

import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class LibrarianTest {

    @Test
    public void shouldGetMainMenu() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        UserCredentials userCredentials = mock(UserCredentials.class);
        Librarian librarian = new Librarian(userCredentials, "", "", "");

        assertEquals(MainMenu.class, librarian.getMainMenu(session, library, messages, users, userInterface).getClass());
    }
}
