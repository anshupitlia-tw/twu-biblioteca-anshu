package com.twu.biblioteca.factories;

import java.util.ArrayList;
import java.util.List;

public class LibraryFactory {

    public com.twu.biblioteca.models.Library establishLibrary(com.twu.biblioteca.authentication.Session session) {
        List<com.twu.biblioteca.models.Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new com.twu.biblioteca.models.AvailableBook("Anna Karenina", "Leo Tolstoy", (short) 1878));
        listOfBooks.add(new com.twu.biblioteca.models.AvailableBook("Madame Bovary", "Gustave Flaubert", (short) 1856));
        listOfBooks.add(new com.twu.biblioteca.models.AvailableBook("War and Peace", "Leo Tolstoy", (short) 1869));
        listOfBooks.add(new com.twu.biblioteca.models.AvailableBook("Lolita", "Vladimir Nabokov", (short) 1955));
        listOfBooks.add(new com.twu.biblioteca.models.AvailableBook("The Adventures of Huckleberry Finn", "Mark Twain", (short) 1884));
        listOfBooks.add(new com.twu.biblioteca.models.AvailableBook("Hamlet", "William Shakespeare", (short) 1599));
        listOfBooks.add(new com.twu.biblioteca.models.AvailableBook("The Great Gatsby", "F. Scott Fitzgerald", (short) 1925));
        listOfBooks.add(new com.twu.biblioteca.models.AvailableBook("In Search of Lost Time", "Marcel Proust", (short) 1871));
        listOfBooks.add(new com.twu.biblioteca.models.AvailableBook("The Stories of Anton Chekhov", "Anton Chekhov", (short) 1900));
        listOfBooks.add(new com.twu.biblioteca.models.AvailableBook("Middlemarch", "George Eliot", (short) 1871));

        List<com.twu.biblioteca.models.Movie> listOfMovies = new ArrayList<>();
        listOfMovies.add(new com.twu.biblioteca.models.Movie("Titanic", (short) 1997, "James Cameron", com.twu.biblioteca.models.RATING.EIGHT));
        listOfMovies.add(new com.twu.biblioteca.models.Movie("Vertigo", (short) 1958, "Alfred Hitchcock", com.twu.biblioteca.models.RATING.NINE));
        listOfMovies.add(new com.twu.biblioteca.models.Movie("Citizen Kane", (short) 1941, "Orson Welles", com.twu.biblioteca.models.RATING.NINE));
        listOfMovies.add(new com.twu.biblioteca.models.Movie("Tokyo Story", (short) 1953, "Yasujiro Ozu", com.twu.biblioteca.models.RATING.EIGHT));
        listOfMovies.add(new com.twu.biblioteca.models.Movie("Sunrise: A Song Of Two Humans", (short) 1927, "F. W. Murnau", com.twu.biblioteca.models.RATING.NINE));
        listOfMovies.add(new com.twu.biblioteca.models.Movie("2001: A Space Odyssey", (short) 1968, "Stanley Kubric", com.twu.biblioteca.models.RATING.EIGHT));
        listOfMovies.add(new com.twu.biblioteca.models.Movie("The Searchers", (short) 1956, "John Ford", com.twu.biblioteca.models.RATING.EIGHT));
        listOfMovies.add(new com.twu.biblioteca.models.Movie("Man with a Movie Camera", (short) 1929, "Dziga Vertov", com.twu.biblioteca.models.RATING.NINE));
        listOfMovies.add(new com.twu.biblioteca.models.Movie("The Passion of Joan of Arc", (short) 1928, "Carl Theodor Dreyer", com.twu.biblioteca.models.RATING.NINE));
        listOfMovies.add(new com.twu.biblioteca.models.Movie("Battleship Potemkin", (short) 1925, "Sergei M. Eisenstein", com.twu.biblioteca.models.RATING.EIGHT));

        com.twu.biblioteca.models.Library library = new com.twu.biblioteca.models.Library(listOfBooks, listOfMovies, session);
        return library;
    }

}
