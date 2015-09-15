package com.twu.biblioteca;

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
}
