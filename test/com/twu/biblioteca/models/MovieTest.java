package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldReturnMovieDetailsInDisplayableFormat() {
        Movie movie = new Movie("Titanic", (short)1997, "James Cameron", RATING.EIGHT);
        StringBuilder detailsOfMovieInProperFormat = new StringBuilder(String.format("%-40s%-40s%-40s%-40s\n","Titanic", "1997", "James Cameron", "EIGHT"));

        assertEquals(detailsOfMovieInProperFormat.toString(), movie.getMovieDetailsForDisplay());
    }

    @Test
    public void shouldBeAbleToCheckOutSoThatItIsNotAvailable() {
        Movie movie = new Movie("Titanic", (short)1997, "James Cameron", RATING.EIGHT);
        movie.checkOut();
        StringBuilder detailsOfMovieInProperFormat = new StringBuilder(String.format(""));

        assertEquals(detailsOfMovieInProperFormat.toString(), movie.getMovieDetailsForDisplay());
    }

    @Test
    public void shouldReturnTrueIfMovieCheckedOut() {
        Movie movie = new Movie("Titanic", (short)1997, "James Cameron", RATING.EIGHT);

        assertEquals(true, movie.checkOut());
    }

    @Test
    public void shouldReturnFalseIfMovieNotCheckedOut() {
        Movie movie = new Movie("Titanic", (short)1997, "James Cameron", RATING.EIGHT);
        movie.checkOut();

        assertEquals(false, movie.checkOut());
    }

    @Test
    public void shouldBeAbleToMatchAMovieNameGivenInAnyCase() {
        Movie movie = new Movie("Titanic", (short)1997, "James Cameron", RATING.EIGHT);

        assertEquals(true, movie.match("titanic"));
    }

    @Test
    public void shouldBeAbleToMatchAMovieNameWithItself() {
        Movie movie = new Movie("Titanic", (short)1997, "James Cameron", RATING.EIGHT);

        assertEquals(true, movie.match("Titanic"));
    }
}

