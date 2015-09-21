package com.twu.biblioteca.menu_items;

import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutMovieMenuItemTest {

    @Test
    public void shouldAskALibraryToCheckOutAMovie() {
        Library library = mock(Library.class);
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        CheckoutMovieMenuItem checkoutMovieMenuItem = new com.twu.biblioteca.menu_items.CheckoutMovieMenuItem("Checkout A Movie",library, userInterface, messages);

        when(messages.getUXMessage("enter_movie_name")).thenReturn("Enter Movie Name");
        when(userInterface.getChoiceFromUser()).thenReturn("Titanic");

        checkoutMovieMenuItem.execute();

        verify(library, times(1)).checkOutMovie("Titanic");
    }

    @Test
    public void shouldPrintSuccessfulMessageOnTheUIIfTheMovieHasBeenCheckedOut() {
        Library library = mock(Library.class);
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        CheckoutMovieMenuItem checkoutMovieMenuItem = new CheckoutMovieMenuItem("Checkout A Movie",library, userInterface, messages);

        when(messages.getUXMessage("enter_movie_name")).thenReturn("Enter Movie Name");
        when(userInterface.getChoiceFromUser()).thenReturn("Titanic");
        when(library.checkOutMovie("Titanic")).thenReturn(true);
        when(messages.getUXMessage("successful_checkout_movie")).thenReturn("Thank you! Enjoy the movie");
        checkoutMovieMenuItem.execute();

        verify(userInterface, times(1)).printOnOutputStream("Thank you! Enjoy the movie");
    }

    @Test
    public void shouldPrintUnSuccessfulMessageOnTheUIIfTheMovieIsNotCheckedOut() {
        Library library = mock(Library.class);
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        CheckoutMovieMenuItem checkoutMovieMenuItem = new CheckoutMovieMenuItem("Checkout A Movie",library, userInterface, messages);

        when(messages.getUXMessage("enter_movie_name")).thenReturn("Enter Movie Name");
        when(userInterface.getChoiceFromUser()).thenReturn("Titanic");
        when(library.checkOutMovie("Titanic")).thenReturn(false);
        when(messages.getUXMessage("unsuccessful_checkout_movie")).thenReturn("That movie is not available. Please select a different movie, or fix the spelling error");
        checkoutMovieMenuItem.execute();

        verify(userInterface, times(1)).printOnOutputStream("That movie is not available. Please select a different movie, or fix the spelling error");
    }
}
