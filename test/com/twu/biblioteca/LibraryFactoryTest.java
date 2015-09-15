package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class LibraryFactoryTest {

    private Library library;

    @Before
    public void setLibrary() {
        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        listOfBooks.add(new Book("Madame Bovary", "Gustave Flaubert", (short) 1856));
        listOfBooks.add(new Book("War and Peace", "Leo Tolstoy", (short) 1869));
        listOfBooks.add(new Book("Lolita", "Vladimir Nabokov", (short) 1955));
        listOfBooks.add(new Book("The Adventures of Huckleberry Finn", "Mark Twain", (short) 1884));
        listOfBooks.add(new Book("Hamlet", "William Shakespeare", (short) 1599));
        listOfBooks.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", (short) 1925));
        listOfBooks.add(new Book("In Search of Lost Time", "Marcel Proust", (short) 1871));
        listOfBooks.add(new Book("The Stories of Anton Chekhov", "Anton Chekhov", (short) 1900));
        listOfBooks.add(new Book("Middlemarch", "George Eliot", (short) 1871));

        List<Movie> listOfMovies = new ArrayList<>();
        listOfMovies.add(new Movie("Titanic", (short) 1997, "James Cameron", RATING.EIGHT));
        listOfMovies.add(new Movie("Vertigo", (short) 1958, "Alfred Hitchcock", RATING.NINE));
        library = new Library(listOfBooks, listOfMovies);
    }


    @Test
    public void shouldHaveAllTheBooksInTheLibrary() {
        assertEquals(library.getBookListForDisplay(), new LibraryFactory().establishLibrary().getBookListForDisplay());
    }
}
