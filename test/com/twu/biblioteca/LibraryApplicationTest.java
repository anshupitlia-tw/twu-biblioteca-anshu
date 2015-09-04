package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class LibraryApplicationTest {

    @Test
    public void shouldStartWithAWelcomeMessageAndPrintItOnTheUserInterface() {
        UserInterface ui = mock(UserInterface.class);
        Messages messages = mock(Messages.class);

        when(messages.getUXMessage("welcome_message")).thenReturn("Welcome! Biblioteca at your service");
        LibraryApplication libraryApplication = new LibraryApplication(ui, messages);
        libraryApplication.start();

        verify(ui, times(1)).print("Welcome! Biblioteca at your service");
    }
}
