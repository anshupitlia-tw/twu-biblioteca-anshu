
package com.twu.biblioteca.factories;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryApplicationFactoryTest {

    @Test
    public void shouldCreateALibraryApplication() {
        com.twu.biblioteca.factories.LibraryApplicationFactory libraryApplicationFactory = new com.twu.biblioteca.factories.LibraryApplicationFactory();
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = mock(com.twu.biblioteca.main_menu.MainMenu.class);
        com.twu.biblioteca.authentication.User user = mock(com.twu.biblioteca.authentication.User.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);


        when(session.getCurrentUser()).thenReturn(user);
        when(user.getMainMenu(session, library, messages, users, userInterface)).thenReturn(mainMenu);

        assertEquals(com.twu.biblioteca.controller.LibraryApplication.class, libraryApplicationFactory.getTheEstablishedLibraryApplication(session).getClass());
    }
}


