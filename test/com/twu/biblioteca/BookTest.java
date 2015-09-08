package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldReturnBookDetailsInPrintableFormat() {
        Book book = new Book("Anna Karenina", "Leo Tolstoy", (short) 1878);
        String detailsOfBookInProperFormat = "Anna Karenina\tLeo Tolstoy\t1878\n";

        assertEquals(detailsOfBookInProperFormat, book.getBookDetailsForDisplay());
    }

    @Test
    public void shouldReturnBookDetailsInPrintableFormatIfDifferentBook() {
        Book book = new Book("Madame Bovary", "Gustave Flaubert", (short)1856);
        String detailsOfBookInProperFormat = "Madame Bovary\tGustave Flaubert\t1856\n";

        assertEquals(detailsOfBookInProperFormat, book.getBookDetailsForDisplay());
    }

    @Test
    public void shouldReturnTrueIfTheBookIsMatchedWithTheSearchedBookName() {
        Book book = new Book("Anna Karenina", "Leo Tolstoy", (short) 1878);
        String bookName = "Anna Karenina";

        assertEquals(true, book.match(bookName));
    }

    @Test
    public void shouldReturnFalseIfTheBookIsNotMatchedWithTheSearchedBookName() {
        Book book = new Book("Anna Karenina", "Leo Tolstoy", (short) 1878);
        String bookName = "Anna Kareina";

        assertEquals(false, book.match(bookName));
    }

    @Test
    public void shouldBeAbleToCheckOutABookIfNotCheckedOutAlready() {
        Book book = new Book("Anna Karenina", "Leo Tolstoy", (short) 1878);

        assertEquals(true, book.checkOut());
    }

    @Test
    public void shouldNotBeAbleToCheckOutABookIfCheckedOutAlready() {
        Book book = new Book("Anna Karenina", "Leo Tolstoy", (short) 1878);
        book.checkOut();

        assertEquals(false, book.checkOut());
    }

    @Test
    public void shouldNotShowABookInTheListIfCheckedOut() {
        Book book = new Book("Anna Karenina", "Leo Tolstoy", (short) 1878);
        book.checkOut();

        assertEquals("", book.getBookDetailsForDisplay());
    }
}