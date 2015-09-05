package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldReturnBookDetailsInPrintableFormat() {
        Book book = new Book("Anna Karenina", "Leo Tolstoy", (short) 1878);
        String detailsOfBookInProperFormat = "Anna Karenina\tLeo Tolstoy\t1878";

        assertEquals(detailsOfBookInProperFormat, book.getBookDetailsForDisplay());
    }

    @Test
    public void shouldReturnBookDetailsInPrintableFormatIfDifferentBook() {
        Book book = new Book("Madame Bovary", "Gustave Flaubert", (short)1856);
        String detailsOfBookInProperFormat = "Madame Bovary\tGustave Flaubert\t1856";

        assertEquals(detailsOfBookInProperFormat, book.getBookDetailsForDisplay());
    }
}