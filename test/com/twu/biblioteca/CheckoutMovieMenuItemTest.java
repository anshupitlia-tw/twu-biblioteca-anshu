package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutMovieMenuItemTest {

    @Test
    public void shouldAskALibraryToCheckOutAMovie() {
        Library library = mock(Library.class);
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        CheckoutMovieMenuItem checkoutMovieMenuItem = new CheckoutMovieMenuItem("Checkout A Movie",library, userInterface, messages);

        when(messages.getUXMessage("enter_movie_name")).thenReturn("Enter Movie Name");
        when(userInterface.getChoiceFromUser()).thenReturn("Titanic");

        checkoutMovieMenuItem.execute();

        verify(library, times(1)).checkOutMovie("Titanic");
    }
}
