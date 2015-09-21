package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldReturnBookDetailsInPrintableFormat() {
        com.twu.biblioteca.models.Book book = new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878);
        StringBuilder detailsOfBookInProperFormat = new StringBuilder(String.format("%-40s%-40s%-40s\n","Anna Karenina", "Leo Tolstoy", "1878"));

        assertEquals(detailsOfBookInProperFormat.toString(), book.getAvailableBookDetailsForDisplay());
    }

    @Test
    public void shouldReturnBookDetailsInPrintableFormatIfDifferentBook() {
        com.twu.biblioteca.models.Book book = new com.twu.biblioteca.models.AvailableBook("Madame Bovary", "Gustave Flaubert", (short)1856);
        StringBuilder detailsOfBookInProperFormat = new StringBuilder(String.format("%-40s%-40s%-40s\n","Madame Bovary", "Gustave Flaubert", "1856"));

        assertEquals(detailsOfBookInProperFormat.toString(), book.getAvailableBookDetailsForDisplay());
    }

    @Test
    public void shouldReturnTrueIfTheBookIsMatchedWithTheSearchedBookName() {
        com.twu.biblioteca.models.Book book = new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878);
        String bookName = "Anna Karenina";

        assertEquals(true, book.match(bookName));
    }

    @Test
    public void shouldReturnFalseIfTheBookIsNotMatchedWithTheSearchedBookName() {
        com.twu.biblioteca.models.Book book = new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878);
        String bookName = "Anna Kareina";

        assertEquals(false, book.match(bookName));
    }

    @Test
    public void shouldBeAbleToCheckOutABookIfNotCheckedOutAlready() {
        com.twu.biblioteca.models.Book book = new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878);

        assertEquals(true, book.canBeCheckedOut());
    }

    @Test
    public void shouldMatchBookNameGivenInAnyCase() {
        com.twu.biblioteca.models.Book book = new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878 );

        assertEquals(true, book.match("anna karenina"));
    }
}