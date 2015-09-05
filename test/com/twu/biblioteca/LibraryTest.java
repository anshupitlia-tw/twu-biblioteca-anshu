package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    @Test
    public void shouldReturnTheListOfBooksForDisplay() {
        List<String> booksList = new ArrayList<>();
        booksList.add("Anna Karenina");
        booksList.add("Madame Bovary");
        Library library = new Library(booksList);
        String expectedList = "Anna Karenina\nMadame Bovary\n";

        assertEquals(expectedList, library.getBookListForDisplay());
    }
}
