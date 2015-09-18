package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckedOutBookTest {

    @Test
    public void shouldNotDisplayItselfInTheListOfAvailableBooks() {
        User checkedOutByUser = mock(User.class);
        CheckedOutBook checkedOutBook = new CheckedOutBook("Book1", "Author1", (short)1991, checkedOutByUser);

        assertEquals("", checkedOutBook.getAvailableBookDetailsForDisplay());
    }

    @Test
    public void shouldNotBeAbleToGetCheckedOut() {
        User checkedOutByUser = mock(User.class);
        CheckedOutBook checkedOutBook = new CheckedOutBook("Book1", "Author1", (short)1991, checkedOutByUser);

        assertEquals(false, checkedOutBook.canBeCheckedOut());
    }

    @Test
    public void shouldBeAbleToGetReturnedIfCheckedOutBySameUser() {
        User checkedOutByUser = mock(User.class);
        CheckedOutBook checkedOutBook = new CheckedOutBook("Book1", "Author1", (short)1991, checkedOutByUser);

        assertEquals(true, checkedOutBook.canBeReturned(checkedOutByUser));
    }

    @Test
    public void shouldNotBeAbleToGetReturnedIfCheckedOutByDifferentUser() {
        User checkedOutByUser = mock(User.class);
        User returnedByUser = mock(User.class);
        CheckedOutBook checkedOutBook = new CheckedOutBook("Book1", "Author1", (short)1991, checkedOutByUser);

        assertEquals(false, checkedOutBook.canBeReturned(returnedByUser));
    }

    @Test
    public void shouldProvideTitleAndCheckedOutByUsersLibraryNumberInDisplayableFormat() {
        User checkedOutByUser = mock(User.class);
        when(checkedOutByUser.getLibraryNumber()).thenReturn("bib-0001");
        CheckedOutBook checkedOutBook = new CheckedOutBook("Book1", "Author1", (short)1991, checkedOutByUser);

        StringBuilder stringBuilder = new StringBuilder().append(String.format("%-40s%-40s\n", "Book1", "bib-0001"));
        String expectedString =  stringBuilder.toString();

        assertEquals(expectedString, checkedOutBook.getCheckedOutBookDetailsForDisplay());
    }
}
