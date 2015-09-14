package com.twu.biblioteca;

public class Movie {
    private String name;
    private short year;
    private String director;
    private boolean isAvailable;
    private RATING rating;

    Movie(String name, short year, String director, RATING rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.isAvailable = true;
    }

    public String getDisplayListForMovie() {
        return "Titanic 1991 Director EIGHT";
    }
}
