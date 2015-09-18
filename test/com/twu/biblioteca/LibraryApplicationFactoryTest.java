
package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryApplicationFactoryTest {

    @Test
    public void shouldCreateALibraryApplication() {
        LibraryApplicationFactory libraryApplicationFactory = new LibraryApplicationFactory();
        Session session = mock(Session.class);
        MainMenu mainMenu = mock(MainMenu.class);
        User user = mock(User.class);

        when(session.getCurrentUser()).thenReturn(user);
        when(user.getMainMenu(session)).thenReturn(mainMenu);

        assertEquals(LibraryApplication.class, libraryApplicationFactory.getTheEstablishedLibraryApplication(session).getClass());
    }
}

