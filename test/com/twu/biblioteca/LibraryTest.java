package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    @Test
    public void shouldReturnTheListOfBooksForDisplay() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new Book("Madame Bovary", "Gustave Flaubert", (short)1856));

        Library library = new Library(booksList);
        String expectedList = "NAME\tAUTHOR\tYEAR PUBLISHED\n" +
                "Anna Karenina\tLeo Tolstoy\t1878\n" +
                "Madame Bovary\tGustave Flaubert\t1856\n";

        assertEquals(expectedList, library.getBookListForDisplay());
    }
}
