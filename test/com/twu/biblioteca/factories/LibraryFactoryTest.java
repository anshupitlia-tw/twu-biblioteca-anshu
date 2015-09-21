package com.twu.biblioteca.factories;

import com.twu.biblioteca.authentication.Session;
import com.twu.biblioteca.models.AvailableBook;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.models.Movie;
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
        Session session = new SessionFactory().createGuestSession();
        listOfBooks.add(new AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878));
        listOfBooks.add(new AvailableBook("Madame Bovary", "Gustave Flaubert", (short) 1856));
        listOfBooks.add(new AvailableBook("War and Peace", "Leo Tolstoy", (short) 1869));
        listOfBooks.add(new AvailableBook("Lolita", "Vladimir Nabokov", (short) 1955));
        listOfBooks.add(new AvailableBook("The Adventures of Huckleberry Finn", "Mark Twain", (short) 1884));
        listOfBooks.add(new AvailableBook("Hamlet", "William Shakespeare", (short) 1599));
        listOfBooks.add(new AvailableBook("The Great Gatsby", "F. Scott Fitzgerald", (short) 1925));
        listOfBooks.add(new AvailableBook("In Search of Lost Time", "Marcel Proust", (short) 1871));
        listOfBooks.add(new AvailableBook("The Stories of Anton Chekhov", "Anton Chekhov", (short) 1900));
        listOfBooks.add(new AvailableBook("Middlemarch", "George Eliot", (short) 1871));

        List<Movie> listOfMovies = new ArrayList<>();
        listOfMovies.add(new Movie("Titanic", (short) 1997, "James Cameron", com.twu.biblioteca.models.RATING.EIGHT));
        listOfMovies.add(new Movie("Vertigo", (short) 1958, "Alfred Hitchcock", com.twu.biblioteca.models.RATING.NINE));
        listOfMovies.add(new Movie("Citizen Kane", (short) 1941, "Orson Welles", com.twu.biblioteca.models.RATING.NINE));
        listOfMovies.add(new Movie("Tokyo Story", (short) 1953, "Yasujiro Ozu", com.twu.biblioteca.models.RATING.EIGHT));
        listOfMovies.add(new Movie("Sunrise: A Song Of Two Humans", (short) 1927, "F. W. Murnau", com.twu.biblioteca.models.RATING.NINE));
        listOfMovies.add(new Movie("2001: A Space Odyssey", (short) 1968, "Stanley Kubric", com.twu.biblioteca.models.RATING.EIGHT));
        listOfMovies.add(new Movie("The Searchers", (short) 1956, "John Ford", com.twu.biblioteca.models.RATING.EIGHT));
        listOfMovies.add(new Movie("Man with a Movie Camera", (short) 1929, "Dziga Vertov", com.twu.biblioteca.models.RATING.NINE));
        listOfMovies.add(new Movie("The Passion of Joan of Arc", (short) 1928, "Carl Theodor Dreyer", com.twu.biblioteca.models.RATING.NINE));
        listOfMovies.add(new Movie("Battleship Potemkin", (short) 1925, "Sergei M. Eisenstein", com.twu.biblioteca.models.RATING.EIGHT));

        library = new Library(listOfBooks, listOfMovies, session);
    }


    @Test
    public void shouldHaveAllTheBooksInTheLibrary() {
        Session session = new SessionFactory().createGuestSession();
        assertEquals(library.getAvailableBookListForDisplay(), new LibraryFactory().establishLibrary(session).getAvailableBookListForDisplay());
    }

    @Test
    public void shouldHaveAllTheMoviesInTheLibrary() {
        Session session = new SessionFactory().createGuestSession();
        assertEquals(library.getMovieListForDisplay(), new LibraryFactory().establishLibrary(session).getMovieListForDisplay());
    }
}
