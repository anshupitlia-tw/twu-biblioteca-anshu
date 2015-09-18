
package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ListBooksMenuItemTest {

    @Test
    public void shouldPrintListOfBooksOnTheUserInterfaceWhenTheMenuIsExecuted() {
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);

        ListBooksMenuItem listBooksMenu = new ListBooksMenuItem("List Books", userInterface, library);
        when(library.getAvailableBookListForDisplay()).thenReturn("Some List");
        listBooksMenu.execute();
        verify(userInterface, times(1)).printOnOutputStream("Some List");
    }
}

