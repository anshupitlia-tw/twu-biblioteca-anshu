
package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ListBooksMenuTest {

    @Test
    public void shouldPrintListOfBooksOnTheUserInterfaceWhenTheMenuIsExecuted() {
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);

        ListBooksMenu listBooksMenu = new ListBooksMenu("List Books", userInterface, library);
        when(library.getBookListForDisplay()).thenReturn("Some List");
        listBooksMenu.execute();
        verify(userInterface, times(1)).print("Some List");
    }
}

