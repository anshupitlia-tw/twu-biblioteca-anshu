

package com.twu.biblioteca.menu_items;

import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.helpers.LoginCaller;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutBookMenuItemTest {

    @Test
    public void shouldCheckoutABookAndDisplaySuccessfulCheckoutMessageIfSuccessfullyCheckedOut() {
        Library library = mock(Library.class);
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        LoginCaller loginCaller = mock(LoginCaller.class);
        CheckoutBookMenuItem checkoutBook = new CheckoutBookMenuItem("Checkout A Book",library, userInterface, loginCaller, messages);

        when(loginCaller.callLoginViewForUser()).thenReturn(true);
        when(messages.getUXMessage("enter_book_name")).thenReturn("Enter the Book Name");
        when(userInterface.getChoiceFromUser()).thenReturn("Anna Karenina");
        when(library.checkOutBook("Anna Karenina")).thenReturn(true);
        when(messages.getUXMessage("successful_checkout")).thenReturn("Thank you! Enjoy the book");
        checkoutBook.execute();

        verify(userInterface, times(1)).printOnOutputStream("Thank you! Enjoy the book");
    }

    @Test
    public void shouldTryToCheckOutABookAndDisplayUnSuccessfulCheckoutMessageIfNotFound() {
        Library library = mock(Library.class);
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        LoginCaller loginCaller = mock(LoginCaller.class);
        CheckoutBookMenuItem checkoutBook = new CheckoutBookMenuItem("Checkout A Book",library, userInterface, loginCaller, messages);

        when(loginCaller.callLoginViewForUser()).thenReturn(true);
        when(messages.getUXMessage("enter_book_name")).thenReturn("Enter the Book Name");
        when(userInterface.getChoiceFromUser()).thenReturn("Anna Kerenina");
        when(library.checkOutBook("Anna Kerenina")).thenReturn(false);
        when(messages.getUXMessage("unsuccessful_checkout")).thenReturn("That book is not available. Please select a different book, or fix the spelling error");
        checkoutBook.execute();

        verify(userInterface, times(1)).printOnOutputStream("That book is not available. Please select a different book, or fix the spelling error");
    }
}


