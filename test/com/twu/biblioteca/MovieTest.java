package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldReturnMovieDetailsInDisplayableFormat() {
        Movie movie = new Movie("Titanic", (short)1991, "Director", RATING.EIGHT);

        assertEquals("Titanic 1991 Director EIGHT", movie.getDisplayListForMovie());
    }
}
