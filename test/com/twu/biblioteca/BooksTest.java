package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BooksTest {
    @Test
    public void shouldReturnTheListOfBooksForDisplay() {
        List<String> booksList = new ArrayList<>();
        booksList.add("Anna Karenina");
        booksList.add("Madame Bovary");
        Books books = new Books(booksList);
        String expectedList = "Anna Karenina\nMadame Bovary\n";

        assertEquals(expectedList, books.getBookListForDisplay());
    }
}
