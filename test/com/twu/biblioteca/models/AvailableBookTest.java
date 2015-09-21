package com.twu.biblioteca.models;

import com.twu.biblioteca.authentication.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class AvailableBookTest {

    @Test
    public void shouldSendItsInformationInDisplayableFormat() {
        AvailableBook availableBook = new AvailableBook("Book1", "Author1", (short)1991);
        StringBuilder bookDetails = new StringBuilder();
        bookDetails.append(String.format("%-40s%-40s%-40s\n", "Book1", "Author1", "1991"));
        String expectedDisplayableDetails = bookDetails.toString();

        assertEquals(expectedDisplayableDetails, availableBook.getAvailableBookDetailsForDisplay());
    }

    @Test
    public void shouldBeAbleToGetCheckedOut() {
        AvailableBook availableBook = new AvailableBook("Book1", "Author1", (short)1991);

        assertEquals(true, availableBook.canBeCheckedOut());
    }

    @Test
    public void shouldNotBeAbleToGetReturned() {
        AvailableBook availableBook = new AvailableBook("Book1", "Author1", (short)1991);
        User user = mock(User.class);

        assertEquals(false, availableBook.canBeReturned(user));
    }

    @Test
    public void shouldReturnEmptyBookDetailsIfAskedForCheckedOutBookDetails() {
        AvailableBook availableBook = new AvailableBook("Book1", "Author1", (short) 1991);

        assertEquals("", availableBook.getCheckedOutBookDetailsForDisplay());
    }
}
