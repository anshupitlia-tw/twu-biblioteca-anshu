package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldReturnMovieDetailsInDisplayableFormat() {
        com.twu.biblioteca.models.Movie movie = new com.twu.biblioteca.models.Movie("Titanic", (short)1997, "James Cameron", com.twu.biblioteca.models.RATING.EIGHT);
        StringBuilder detailsOfMovieInProperFormat = new StringBuilder(String.format("%-40s%-40s%-40s%-40s\n","Titanic", "1997", "James Cameron", "EIGHT"));

        assertEquals(detailsOfMovieInProperFormat.toString(), movie.getMovieDetailsForDisplay());
    }

    @Test
    public void shouldBeAbleToCheckOutSoThatItIsNotAvailable() {
        com.twu.biblioteca.models.Movie movie = new com.twu.biblioteca.models.Movie("Titanic", (short)1997, "James Cameron", com.twu.biblioteca.models.RATING.EIGHT);
        movie.checkOut();
        StringBuilder detailsOfMovieInProperFormat = new StringBuilder(String.format(""));

        assertEquals(detailsOfMovieInProperFormat.toString(), movie.getMovieDetailsForDisplay());
    }

    @Test
    public void shouldReturnTrueIfMovieCheckedOut() {
        com.twu.biblioteca.models.Movie movie = new com.twu.biblioteca.models.Movie("Titanic", (short)1997, "James Cameron", com.twu.biblioteca.models.RATING.EIGHT);

        assertEquals(true, movie.checkOut());
    }

    @Test
    public void shouldReturnFalseIfMovieNotCheckedOut() {
        com.twu.biblioteca.models.Movie movie = new com.twu.biblioteca.models.Movie("Titanic", (short)1997, "James Cameron", com.twu.biblioteca.models.RATING.EIGHT);
        movie.checkOut();

        assertEquals(false, movie.checkOut());
    }

    @Test
    public void shouldBeAbleToMatchAMovieNameGivenInAnyCase() {
        com.twu.biblioteca.models.Movie movie = new com.twu.biblioteca.models.Movie("Titanic", (short)1997, "James Cameron", com.twu.biblioteca.models.RATING.EIGHT);

        assertEquals(true, movie.match("titanic"));
    }

    @Test
    public void shouldBeAbleToMatchAMovieNameWithItself() {
        com.twu.biblioteca.models.Movie movie = new com.twu.biblioteca.models.Movie("Titanic", (short)1997, "James Cameron", com.twu.biblioteca.models.RATING.EIGHT);

        assertEquals(true, movie.match("Titanic"));
    }
}

