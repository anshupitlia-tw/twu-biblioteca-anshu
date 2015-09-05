package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class LibraryApplicationTest {

    @Test
    public void shouldStartWithAWelcomeMessageAndPrintItOnTheUserInterface() {
        UserInterface ui = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);

        when(messages.getUXMessage("welcome_message")).thenReturn("Welcome! Biblioteca at your service");

        LibraryApplication libraryApplication = new LibraryApplication(ui, messages, library);
        libraryApplication.start();

        verify(ui, times(1)).print("Welcome! Biblioteca at your service");
    }

    @Test
    public void shouldDisplayTheListOfBooksOnUserInterface() {
        UserInterface ui = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);

        when(library.getBookListForDisplay()).thenReturn("Book1\nBook2");

        LibraryApplication libraryApplication = new LibraryApplication(ui, messages, library);
        libraryApplication.listBooks();

        verify(ui, times(1)).print("Book1\nBook2");
    }
}
