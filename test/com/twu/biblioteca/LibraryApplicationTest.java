package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LibraryApplicationTest {

    @Test
    public void shouldStartWithAWelcomeMessageAndPrintItOnTheUserInterface() {
        UserInterface ui = mock(UserInterface.class);
        LibraryApplication libraryApplication = new LibraryApplication(ui);
        libraryApplication.start();

        verify(ui, times(1)).print("Welcome! Biblioteca at your service");
    }
}
