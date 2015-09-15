package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class LibraryTest {
    @Test
    public void shouldReturnTheListOfBooksForDisplay() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new Book("Madame Bovary", "Gustave Flaubert", (short)1856));
        List<Movie> movieList = mock(List.class);

        Library library = new Library(booksList,  movieList);

        StringBuilder expectedList = new StringBuilder(String.format("%-40s%-40s%-40s\n%-40s%-40s%-40s\n%-40s%-40s%-40s\n","NAME", "AUTHOR", "YEAR PUBLISHED",
                "Anna Karenina", "Leo Tolstoy", "1878",
                "Madame Bovary", "Gustave Flaubert", "1856"));

        assertEquals(expectedList.toString(), library.getBookListForDisplay());
    }

    @Test
    public void shouldReturnTrueIfBookFoundInLibraryAndCheckedOut() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new Book("Madame Bovary", "Gustave Flaubert", (short) 1856));

        List<Movie> movieList = mock(List.class);
        Library library = new Library(booksList,  movieList);

        assertEquals(true, library.checkOutBook("Anna Karenina"));
    }


    @Test
    public void shouldNotDisplayTheBookCheckedOut() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new Book("Madame Bovary", "Gustave Flaubert", (short)1856));

        List<Movie> movieList = mock(List.class);
        Library library = new Library(booksList,  movieList);

        library.checkOutBook("Anna Karenina");
        StringBuilder expectedList = new StringBuilder(String.format("%-40s%-40s%-40s\n%-40s%-40s%-40s\n","NAME", "AUTHOR", "YEAR PUBLISHED",
                "Madame Bovary", "Gustave Flaubert", "1856"));

        assertEquals(expectedList.toString(), library.getBookListForDisplay());
    }

    @Test
    public void shouldReturnFalseIfBookFoundInLibraryButCanNotBeCheckedOutBecauseItIsAlreadyCheckedOut() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new Book("Madame Bovary", "Gustave Flaubert", (short) 1856));

        List<Movie> movieList = mock(List.class);
        Library library = new Library(booksList,  movieList);

        library.checkOutBook("Anna Karenina");
        assertEquals(false, library.checkOutBook("Anna Karenina"));
    }

    @Test
    public void shouldReturnFalseIfBookNotFoundInTheLibrary() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new Book("Madame Bovary", "Gustave Flaubert", (short) 1856));

        List<Movie> movieList = mock(List.class);
        Library library = new Library(booksList,  movieList);

        assertEquals(false, library.checkOutBook("Any other book"));
    }

    @Test
    public void shouldBeAbleToReturnABook() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new Book("Madame Bovary", "Gustave Flaubert", (short)1856));
        List<Movie> movieList = mock(List.class);
        Library library = new Library(booksList,  movieList);
        library.checkOutBook("Anna Karenina");

        assertEquals(true, library.returnBook("Anna Karenina"));
    }

    @Test
    public void shouldShowTheBookReturnedInTheListOfBooks() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new Book("Madame Bovary", "Gustave Flaubert", (short) 1856));

        List<Movie> movieList = mock(List.class);
        Library library = new Library(booksList,  movieList);

        library.checkOutBook("Anna Karenina");
        library.returnBook("Anna Karenina");
        StringBuilder expectedList = new StringBuilder(String.format("%-40s%-40s%-40s\n%-40s%-40s%-40s\n%-40s%-40s%-40s\n","NAME", "AUTHOR", "YEAR PUBLISHED",
                "Anna Karenina", "Leo Tolstoy", "1878",
                "Madame Bovary", "Gustave Flaubert", "1856"));

        assertEquals(expectedList.toString(), library.getBookListForDisplay());
    }

    @Test
    public void shouldReturnTheListOfMoviesForDisplay() {
        List<Book> booksList = mock(List.class);
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Titanic", (short) 1997, "James Cameron", RATING.EIGHT));
        movieList.add(new Movie("Vertigo", (short) 1958, "Alfred Hitchcock", RATING.NINE));
        Library library = new Library(booksList,  movieList);

        StringBuilder expectedList = new StringBuilder(String.format("%-40s%-40s%-40s%-40s\n%-40s%-40s%-40s%-40s\n%-40s%-40s%-40s%-40s\n",
                "NAME", "YEAR RELEASED", "DIRECTOR", "RATING",
                "Titanic", "1997", "James Cameron", "EIGHT",
                "Vertigo", "1958",  "Alfred Hitchcock", "NINE"));

        assertEquals(expectedList.toString(), library.getMovieListForDisplay());
    }
}
