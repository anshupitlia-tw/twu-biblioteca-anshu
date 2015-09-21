package com.twu.biblioteca.models;

import com.twu.biblioteca.authentication.Session;
import com.twu.biblioteca.authentication.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {
    @Test
    public void shouldReturnTheListOfBooksForDisplay() {
        List<com.twu.biblioteca.models.Book> booksList = new ArrayList<>();
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Madame Bovary", "Gustave Flaubert", (short)1856));
        List<com.twu.biblioteca.models.Movie> movieList = mock(List.class);
        Session session = mock(Session.class);

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(booksList,  movieList, session);

        StringBuilder expectedList = new StringBuilder(String.format("%-40s%-40s%-40s\n%-40s%-40s%-40s\n%-40s%-40s%-40s\n","NAME", "AUTHOR", "YEAR PUBLISHED",
                "Anna Karenina", "Leo Tolstoy", "1878",
                "Madame Bovary", "Gustave Flaubert", "1856"));

        assertEquals(expectedList.toString(), library.getAvailableBookListForDisplay());
    }

    @Test
    public void shouldReturnTrueIfBookFoundInLibraryAndCheckedOut() {
        List<com.twu.biblioteca.models.Book> booksList = new ArrayList<>();
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Madame Bovary", "Gustave Flaubert", (short) 1856));
        List<com.twu.biblioteca.models.Movie> movieList = mock(List.class);
        Session session = mock(Session.class);

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(booksList,  movieList, session);

        assertEquals(true, library.checkOutBook("Anna Karenina"));
    }


    @Test
    public void shouldNotDisplayTheBookCheckedOut() {
        List<com.twu.biblioteca.models.Book> booksList = new ArrayList<>();
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Madame Bovary", "Gustave Flaubert", (short) 1856));

        List<com.twu.biblioteca.models.Movie> movieList = mock(List.class);
        Session session = mock(Session.class);

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(booksList,  movieList, session);
        library.checkOutBook("Anna Karenina");
        StringBuilder expectedList = new StringBuilder(String.format("%-40s%-40s%-40s\n%-40s%-40s%-40s\n","NAME", "AUTHOR", "YEAR PUBLISHED",
                "Madame Bovary", "Gustave Flaubert", "1856"));

        assertEquals(expectedList.toString(), library.getAvailableBookListForDisplay());
    }

    @Test
    public void shouldReturnFalseIfBookFoundInLibraryButCanNotBeCheckedOutBecauseItIsAlreadyCheckedOut() {
        List<com.twu.biblioteca.models.Book> booksList = new ArrayList<>();
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Madame Bovary", "Gustave Flaubert", (short) 1856));

        List<com.twu.biblioteca.models.Movie> movieList = mock(List.class);
        Session session = mock(Session.class);

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(booksList,  movieList, session);

        library.checkOutBook("Anna Karenina");
        assertEquals(false, library.checkOutBook("Anna Karenina"));
    }

    @Test
    public void shouldReturnFalseIfBookNotFoundInTheLibrary() {
        List<com.twu.biblioteca.models.Book> booksList = new ArrayList<>();
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Madame Bovary", "Gustave Flaubert", (short) 1856));

        List<com.twu.biblioteca.models.Movie> movieList = mock(List.class);
        Session session = mock(Session.class);

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(booksList,  movieList, session);

        assertEquals(false, library.checkOutBook("Any other book"));
    }

    @Test
    public void shouldBeAbleToReturnABookTakenByAMember() {
        List<com.twu.biblioteca.models.Book> booksList = new ArrayList<>();
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Madame Bovary", "Gustave Flaubert", (short) 1856));
        List<com.twu.biblioteca.models.Movie> movieList = mock(List.class);
        Session session = mock(Session.class);
        User user = mock(User.class);
        when(session.getCurrentUser()).thenReturn(user);

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(booksList,  movieList, session);
        library.checkOutBook("Anna Karenina");

        assertEquals(true, library.returnBook("Anna Karenina"));
    }

    @Test
    public void shouldShowTheBookReturnedInTheListOfBooks() {
        List<com.twu.biblioteca.models.Book> booksList = new ArrayList<>();
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Madame Bovary", "Gustave Flaubert", (short) 1856));

        List<com.twu.biblioteca.models.Movie> movieList = mock(List.class);
        Session session = mock(Session.class);
        User user = mock(User.class);
        when(session.getCurrentUser()).thenReturn(user);

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(booksList,  movieList, session);
        library.checkOutBook("Anna Karenina");
        library.returnBook("Anna Karenina");
        StringBuilder expectedList = new StringBuilder(String.format("%-40s%-40s%-40s\n%-40s%-40s%-40s\n%-40s%-40s%-40s\n","NAME", "AUTHOR", "YEAR PUBLISHED",
                "Madame Bovary", "Gustave Flaubert", "1856", "Anna Karenina", "Leo Tolstoy", "1878"));

        assertEquals(expectedList.toString(), library.getAvailableBookListForDisplay());
    }

    @Test
    public void shouldReturnTheListOfMoviesForDisplay() {
        List<com.twu.biblioteca.models.Book> booksList = mock(List.class);
        List<com.twu.biblioteca.models.Movie> movieList = new ArrayList<>();
        movieList.add(new com.twu.biblioteca.models.Movie("Titanic", (short) 1997, "James Cameron", com.twu.biblioteca.models.RATING.EIGHT));
        movieList.add(new com.twu.biblioteca.models.Movie("Vertigo", (short) 1958, "Alfred Hitchcock", com.twu.biblioteca.models.RATING.NINE));
        Session session = mock(Session.class);

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(booksList,  movieList, session);
        StringBuilder expectedList = new StringBuilder(String.format("%-40s%-40s%-40s%-40s\n%-40s%-40s%-40s%-40s\n%-40s%-40s%-40s%-40s\n",
                "NAME", "YEAR RELEASED", "DIRECTOR", "RATING",
                "Titanic", "1997", "James Cameron", "EIGHT",
                "Vertigo", "1958",  "Alfred Hitchcock", "NINE"));

        assertEquals(expectedList.toString(), library.getMovieListForDisplay());
    }

    @Test
    public void shouldBeAbleToCheckOutAMovieSoThatItDoesNotAppearInTheListOfMovies() {
        List<com.twu.biblioteca.models.Book> booksList = mock(List.class);
        List<com.twu.biblioteca.models.Movie> movieList = new ArrayList<>();
        movieList.add(new com.twu.biblioteca.models.Movie("Titanic", (short) 1997, "James Cameron", com.twu.biblioteca.models.RATING.EIGHT));
        movieList.add(new com.twu.biblioteca.models.Movie("Vertigo", (short) 1958, "Alfred Hitchcock", com.twu.biblioteca.models.RATING.NINE));
        Session session = mock(Session.class);

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(booksList,  movieList, session);
        library.checkOutMovie("Titanic");

        StringBuilder expectedList = new StringBuilder(String.format("%-40s%-40s%-40s%-40s\n%-40s%-40s%-40s%-40s\n",
                "NAME", "YEAR RELEASED", "DIRECTOR", "RATING",
                "Vertigo", "1958",  "Alfred Hitchcock", "NINE"));

        assertEquals(expectedList.toString(), library.getMovieListForDisplay());
    }

    @Test
    public void shouldNotBeAbleToCheckOutAMovieWhichDoesNotExist() {
        List<com.twu.biblioteca.models.Book> booksList = mock(List.class);
        List<com.twu.biblioteca.models.Movie> movieList = new ArrayList<>();
        movieList.add(new com.twu.biblioteca.models.Movie("Titanic", (short) 1997, "James Cameron", com.twu.biblioteca.models.RATING.EIGHT));
        movieList.add(new com.twu.biblioteca.models.Movie("Vertigo", (short) 1958, "Alfred Hitchcock", com.twu.biblioteca.models.RATING.NINE));
        Session session = mock(Session.class);

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(booksList,  movieList, session);
        library.checkOutMovie("Titan");

        StringBuilder expectedList = new StringBuilder(String.format("%-40s%-40s%-40s%-40s\n%-40s%-40s%-40s%-40s\n%-40s%-40s%-40s%-40s\n",
                "NAME", "YEAR RELEASED", "DIRECTOR", "RATING",
                "Titanic", "1997", "James Cameron", "EIGHT",
                "Vertigo", "1958",  "Alfred Hitchcock", "NINE"));

        assertEquals(expectedList.toString(), library.getMovieListForDisplay());
    }

    @Test
    public void shouldNotReturnABookFromAUserWhoHadNotCheckedOutTheBook() {
        List<com.twu.biblioteca.models.Book> booksList = new ArrayList<>();
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878));
        booksList.add(new com.twu.biblioteca.models.AvailableBook("Madame Bovary", "Gustave Flaubert", (short) 1856));
        List<com.twu.biblioteca.models.Movie> movieList = mock(List.class);
        Session session = mock(Session.class);
        User userToCheckout = mock(User.class);
        User userToReturn = mock(User.class);
        when(session.getCurrentUser()).thenReturn(userToCheckout, userToReturn);

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(booksList,  movieList, session);
        library.checkOutBook("Anna Karenina");

        assertEquals(false, library.returnBook("Anna Karenina"));
    }

    @Test
    public void shouldReturnTheCheckedOutBookDetailsForDisplay() {
        List<com.twu.biblioteca.models.Book> booksList = new ArrayList<>();
        User checkedOutByUser = mock(User.class);

        com.twu.biblioteca.models.Book book = new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878);
        booksList.add(book);

        List<com.twu.biblioteca.models.Movie> movieList = mock(List.class);

        Session session = mock(Session.class);

        when(checkedOutByUser.getLibraryNumber()).thenReturn("bib-0001");
        when(session.getCurrentUser()).thenReturn(checkedOutByUser);

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(booksList, movieList, session);
        library.checkOutBook("Anna Karenina");

        StringBuilder expectedList = new StringBuilder(String.format("%-40s%-40s\n%-40s%-40s\n",
                "BOOK NAME", "CHECKED OUT BY",
                "Anna Karenina", "bib-0001"));

        assertEquals(expectedList.toString(), library.getCheckedOutBookDetailsForDisplay());
    }

    @Test
    public void shouldBeAbleToCheckOutAnAvailableMovie() {
        List<com.twu.biblioteca.models.Book> booksList = mock(List.class);
        List<com.twu.biblioteca.models.Movie> movieList = new ArrayList<>();
        movieList.add(new com.twu.biblioteca.models.Movie("Titanic", (short) 1997, "James Cameron", com.twu.biblioteca.models.RATING.EIGHT));
        movieList.add(new com.twu.biblioteca.models.Movie("Vertigo", (short) 1958, "Alfred Hitchcock", com.twu.biblioteca.models.RATING.NINE));
        Session session = mock(Session.class);

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(booksList,  movieList, session);

        assertEquals(true, library.checkOutMovie("Titanic"));
    }

    @Test
    public void shouldNotBeAbleToCheckOutAnUnavailableMovie() {
        List<com.twu.biblioteca.models.Book> booksList = mock(List.class);
        List<com.twu.biblioteca.models.Movie> movieList = new ArrayList<>();
        movieList.add(new com.twu.biblioteca.models.Movie("Titanic", (short) 1997, "James Cameron", com.twu.biblioteca.models.RATING.EIGHT));
        movieList.add(new com.twu.biblioteca.models.Movie("Vertigo", (short) 1958, "Alfred Hitchcock", com.twu.biblioteca.models.RATING.NINE));
        Session session = mock(Session.class);

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(booksList,  movieList, session);
        library.checkOutMovie("Titanic");

        assertEquals(false, library.checkOutMovie("Titanic"));
    }
}
