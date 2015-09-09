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

    @Test
    public void shouldReturnTrueIfBookFoundInLibraryAndCheckedOut() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new Book("Madame Bovary", "Gustave Flaubert", (short) 1856));

        Library library = new Library(booksList);
        assertEquals(true, library.checkOutBook("Anna Karenina"));
    }

    @Test
    public void shouldReturnFalseIfBookFoundInLibraryButCanNotBeCheckedOutBecauseItIsAlreadyCheckedOut() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new Book("Madame Bovary", "Gustave Flaubert", (short) 1856));

        Library library = new Library(booksList);
        library.checkOutBook("Anna Karenina");
        assertEquals(false, library.checkOutBook("Anna Karenina"));
    }

    @Test
    public void shouldReturnFalseIfBookNotFoundInTheLibrary() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new Book("Madame Bovary", "Gustave Flaubert", (short) 1856));

        Library library = new Library(booksList);
        assertEquals(false, library.checkOutBook("Any other book"));
    }

    @Test
    public void shouldBeAbleToReturnABook() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new Book("Madame Bovary", "Gustave Flaubert", (short)1856));
        Library library = new Library(booksList);
        library.checkOutBook("Anna Karenina");

        assertEquals(true, library.returnBook("Anna Karenina"));
    }

    @Test
    public void shouldShowTheBookReturnedInTheListOfBooks() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new Book("Madame Bovary", "Gustave Flaubert", (short)1856));

        Library library = new Library(booksList);
        library.checkOutBook("Anna Karenina");
        library.returnBook("Anna Karenina");
        String expectedList = "NAME\tAUTHOR\tYEAR PUBLISHED\n" +
                "Anna Karenina\tLeo Tolstoy\t1878\n" +
                "Madame Bovary\tGustave Flaubert\t1856\n";

        assertEquals(expectedList, library.getBookListForDisplay());
    }
}
