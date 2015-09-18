package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldReturnBookDetailsInPrintableFormat() {
        Book book = new AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878);
        StringBuilder detailsOfBookInProperFormat = new StringBuilder(String.format("%-40s%-40s%-40s\n","Anna Karenina", "Leo Tolstoy", "1878"));

        assertEquals(detailsOfBookInProperFormat.toString(), book.getBookDetailsForDisplay());
    }

    @Test
    public void shouldReturnBookDetailsInPrintableFormatIfDifferentBook() {
        Book book = new AvailableBook("Madame Bovary", "Gustave Flaubert", (short)1856);
        StringBuilder detailsOfBookInProperFormat = new StringBuilder(String.format("%-40s%-40s%-40s\n","Madame Bovary", "Gustave Flaubert", "1856"));

        assertEquals(detailsOfBookInProperFormat.toString(), book.getBookDetailsForDisplay());
    }

    @Test
    public void shouldReturnTrueIfTheBookIsMatchedWithTheSearchedBookName() {
        Book book = new AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878);
        String bookName = "Anna Karenina";

        assertEquals(true, book.match(bookName));
    }

    @Test
    public void shouldReturnFalseIfTheBookIsNotMatchedWithTheSearchedBookName() {
        Book book = new AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878);
        String bookName = "Anna Kareina";

        assertEquals(false, book.match(bookName));
    }

    @Test
    public void shouldBeAbleToCheckOutABookIfNotCheckedOutAlready() {
        Book book = new AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878);

        assertEquals(true, book.checkOutBook());
    }
}