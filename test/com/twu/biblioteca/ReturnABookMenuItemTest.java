package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ReturnABookMenuItemTest {

    @Test
    public void shouldBeAbleToSuccessfullyReturnABookIfItBelongsToTheLibrary() {
        Library library = mock(Library.class);
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        ReturnBookMenuItem returnABookMenu = new ReturnBookMenuItem("return",library, userInterface, messages);

        when(messages.getUXMessage("enter_book_name")).thenReturn("Enter the Book Name");
        when(userInterface.getAStringFromUser()).thenReturn("Anna Karenina");
        when(library.returnBook("Anna Karenina")).thenReturn(true);
        when(messages.getUXMessage("successful_return")).thenReturn("Thank you for returning the book.");
        returnABookMenu.execute();

        verify(userInterface, times(1)).print("Thank you for returning the book.");
    }


    @Test
    public void shouldTellYourUserThatTheBookTheyReturnIsInvalid() {
        Library library = mock(Library.class);
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        ReturnBookMenuItem returnABookMenu = new ReturnBookMenuItem("return",library, userInterface, messages);

        when(messages.getUXMessage("enter_book_name")).thenReturn("Enter the Book Name");
        when(userInterface.getAStringFromUser()).thenReturn("Anna");
        when(library.returnBook("Anna")).thenReturn(false);
        when(messages.getUXMessage("unsuccessful_return")).thenReturn("That is not a valid book to return.");
        returnABookMenu.execute();

        verify(userInterface, times(1)).print("That is not a valid book to return.");
    }
}
