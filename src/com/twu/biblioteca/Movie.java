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

    public String getMovieDetailsForDisplay() {
        StringBuilder movieDetails = new StringBuilder();
        if (isAvailable) {
            movieDetails.append(String.format("%-40s%-40s%-40s%-40s\n", this.name, this.year, this.director, this.rating));
        }
        return movieDetails.toString();
    }

    public void checkOut() {
        isAvailable = false;
    }

    public boolean match(String movieName) {
        return name.equals(movieName);
    }
}
