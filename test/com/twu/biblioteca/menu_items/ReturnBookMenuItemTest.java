
package com.twu.biblioteca.menu_items;

import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.helpers.LoginCaller;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ReturnBookMenuItemTest {

    @Test
    public void shouldBeAbleToSuccessfullyReturnABookIfItBelongsToTheLibrary() {
        Library library = mock(Library.class);
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        LoginCaller loginCaller = mock(LoginCaller.class);
        ReturnBookMenuItem returnABookMenu = new ReturnBookMenuItem("return",library, userInterface, loginCaller, messages);

        when(loginCaller.callLoginViewForUser()).thenReturn(true);
        when(messages.getUXMessage("enter_book_name")).thenReturn("Enter the Book Name");
        when(userInterface.getChoiceFromUser()).thenReturn("Anna Karenina");
        when(library.returnBook("Anna Karenina")).thenReturn(true);
        when(messages.getUXMessage("successful_return")).thenReturn("Thank you for returning the book.");
        returnABookMenu.execute();

        verify(userInterface, times(1)).printOnOutputStream("Thank you for returning the book.");
    }


    @Test
    public void shouldTellYourUserThatTheBookTheyReturnIsInvalid() {
        Library library = mock(Library.class);
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        LoginCaller loginCaller = mock(LoginCaller.class);
        ReturnBookMenuItem returnABookMenu = new ReturnBookMenuItem("return",library, userInterface, loginCaller, messages);
        when(loginCaller.callLoginViewForUser()).thenReturn(true);

        when(messages.getUXMessage("enter_book_name")).thenReturn("Enter the Book Name");
        when(userInterface.getChoiceFromUser()).thenReturn("Anna");
        when(library.returnBook("Anna")).thenReturn(false);
        when(messages.getUXMessage("unsuccessful_return")).thenReturn("That is not a valid book to return.");
        returnABookMenu.execute();

        verify(userInterface, times(1)).printOnOutputStream("That is not a valid book to return.");
    }
}

