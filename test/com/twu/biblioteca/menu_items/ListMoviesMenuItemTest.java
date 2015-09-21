package com.twu.biblioteca.menu_items;

import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ListMoviesMenuItemTest {
    @Test
    public void shouldPrintListOfMoviesOnTheUserInterfaceWhenTheMenuIsExecuted() {
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);

        ListMoviesMenuItem listMoviesMenuItem = new ListMoviesMenuItem("List Movies", userInterface, library);
        when(library.getMovieListForDisplay()).thenReturn("Some List");
        listMoviesMenuItem.execute();
        verify(userInterface, times(1)).printOnOutputStream("Some List");
    }
}
