package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldReturnBookDetailsInPrintableFormat() {
        Book book = new Book("Anna Karenina", "Leo Tolstoy", (short) 1878);
        String detailsOfBookInProperFormat = "Anna Karenina\tLeoTolstoy\t1878";

        assertEquals(detailsOfBookInProperFormat, book.getBookDetailsForDisplay());
    }
}