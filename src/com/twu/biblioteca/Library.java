package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<Book> books;
    private List<Movie> movies;

    public Library(List<Book> books, List<Movie> movies) {
        this.books = books;
        this.movies = movies;
    }

    public String getMovieListForDisplay() {
        StringBuilder movieList = new StringBuilder().append(String.format("%-40s%-40s%-40s%-40s\n", "NAME", "YEAR RELEASED", "DIRECTOR", "RATING"));
        for(Movie movie: movies) {
            movieList.append(movie.getMovieDetailsForDisplay());
        }
        return movieList.toString();
    }

    public String getBookListForDisplay() {
        StringBuilder bookList = new StringBuilder().append(String.format("%-40s%-40s%-40s\n", "NAME", "AUTHOR", "YEAR PUBLISHED"));
        for(Book book: books) {
            bookList.append(book.getBookDetailsForDisplay());
        }
        return bookList.toString();
    }

    private Book findBook(String bookName) {
        for (Book book : books) {
            if (book.match(bookName)) {
                return book;
            }
        }
        return null;
    }

    public boolean checkOutBook(String bookName) {
        Book book = findBook(bookName);
        if (book != null) {
            return book.checkOut();
        }
        return false;
    }

    public boolean returnBook(String bookName) {
        Book book = findBook(bookName);
        if (book != null) {
            return book.returnn();
        }
        return false;
    }
}
