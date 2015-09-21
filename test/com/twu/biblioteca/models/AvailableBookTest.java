package com.twu.biblioteca.models;

import com.twu.biblioteca.authentication.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class AvailableBookTest {

    @Test
    public void shouldSendItsInformationInDisplayableFormat() {
        com.twu.biblioteca.models.AvailableBook availableBook = new com.twu.biblioteca.models.AvailableBook("Book1", "Author1", (short)1991);
        StringBuilder bookDetails = new StringBuilder();
        bookDetails.append(String.format("%-40s%-40s%-40s\n", "Book1", "Author1", "1991"));
        String expectedDisplayableDetails = bookDetails.toString();

        assertEquals(expectedDisplayableDetails, availableBook.getAvailableBookDetailsForDisplay());
    }

    @Test
    public void shouldBeAbleToGetCheckedOut() {
        com.twu.biblioteca.models.AvailableBook availableBook = new com.twu.biblioteca.models.AvailableBook("Book1", "Author1", (short)1991);

        assertEquals(true, availableBook.canBeCheckedOut());
    }

    @Test
    public void shouldNotBeAbleToGetReturned() {
        com.twu.biblioteca.models.AvailableBook availableBook = new com.twu.biblioteca.models.AvailableBook("Book1", "Author1", (short)1991);
        User user = mock(User.class);

        assertEquals(false, availableBook.canBeReturned(user));
    }

    @Test
    public void shouldReturnEmptyBookDetailsIfAskedForCheckedOutBookDetails() {
        com.twu.biblioteca.models.AvailableBook availableBook = new com.twu.biblioteca.models.AvailableBook("Book1", "Author1", (short) 1991);

        assertEquals("", availableBook.getCheckedOutBookDetailsForDisplay());
    }
}
