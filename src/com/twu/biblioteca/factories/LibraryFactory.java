package com.twu.biblioteca.factories;

import com.twu.biblioteca.authentication.Session;
import com.twu.biblioteca.models.*;

import java.util.ArrayList;
import java.util.List;

public class LibraryFactory {

    public Library establishLibrary(Session session) {
        List<Book> listOfBooks = new ArrayList<>();
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
        listOfMovies.add(new Movie("Titanic", (short) 1997, "James Cameron", RATING.EIGHT));
        listOfMovies.add(new Movie("Vertigo", (short) 1958, "Alfred Hitchcock", RATING.NINE));
        listOfMovies.add(new Movie("Citizen Kane", (short) 1941, "Orson Welles", RATING.NINE));
        listOfMovies.add(new Movie("Tokyo Story", (short) 1953, "Yasujiro Ozu", RATING.EIGHT));
        listOfMovies.add(new Movie("Sunrise: A Song Of Two Humans", (short) 1927, "F. W. Murnau", RATING.NINE));
        listOfMovies.add(new Movie("2001: A Space Odyssey", (short) 1968, "Stanley Kubric", RATING.EIGHT));
        listOfMovies.add(new Movie("The Searchers", (short) 1956, "John Ford", RATING.EIGHT));
        listOfMovies.add(new Movie("Man with a Movie Camera", (short) 1929, "Dziga Vertov", RATING.NINE));
        listOfMovies.add(new Movie("The Passion of Joan of Arc", (short) 1928, "Carl Theodor Dreyer", RATING.NINE));
        listOfMovies.add(new Movie("Battleship Potemkin", (short) 1925, "Sergei M. Eisenstein", RATING.EIGHT));

        Library library = new Library(listOfBooks, listOfMovies, session);
        return library;
    }

}
