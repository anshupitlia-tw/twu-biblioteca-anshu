package com.twu.biblioteca.models;

import com.twu.biblioteca.authentication.Session;
import com.twu.biblioteca.authentication.User;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<com.twu.biblioteca.models.Book> availableBooks;
    private List<com.twu.biblioteca.models.Book> checkedOutBooks;
    private List<com.twu.biblioteca.models.Movie> movies;
    private Session session;

    public Library(List<com.twu.biblioteca.models.Book> availableBooks, List<com.twu.biblioteca.models.Movie> movies, Session session) {
        this.availableBooks = availableBooks;
        this.movies = movies;
        this.session = session;
        this.checkedOutBooks = new ArrayList<>();
    }

    public String getCheckedOutBookDetailsForDisplay() {
        StringBuilder checkedOutBookList = new StringBuilder().append(String.format("%-40s%-40s\n", "BOOK NAME", "CHECKED OUT BY"));
        for (com.twu.biblioteca.models.Book book: checkedOutBooks) {
            checkedOutBookList.append(book.getCheckedOutBookDetailsForDisplay());
        }
        return checkedOutBookList.toString();
    }

    public String getMovieListForDisplay() {
        StringBuilder movieList = new StringBuilder().append(String.format("%-40s%-40s%-40s%-40s\n", "NAME", "YEAR RELEASED", "DIRECTOR", "RATING"));
        for(com.twu.biblioteca.models.Movie movie: movies) {
            movieList.append(movie.getMovieDetailsForDisplay());
        }
        return movieList.toString();
    }

    public String getAvailableBookListForDisplay() {
        StringBuilder bookList = new StringBuilder().append(String.format("%-40s%-40s%-40s\n", "NAME", "AUTHOR", "YEAR PUBLISHED"));
        for(com.twu.biblioteca.models.Book book: availableBooks) {
            bookList.append(book.getAvailableBookDetailsForDisplay());
        }
        return bookList.toString();
    }

    private com.twu.biblioteca.models.Book findBook(String bookName, List<com.twu.biblioteca.models.Book> bookList) {
        for (com.twu.biblioteca.models.Book book : bookList) {
            if (book.match(bookName)) {
                return book;
            }
        }
        return null;
    }

    public boolean checkOutBook(String bookName) {
        com.twu.biblioteca.models.Book book = findBook(bookName, availableBooks);
        if (book != null) {
            if (book.canBeCheckedOut()) {
                availableBooks.remove(book);
                com.twu.biblioteca.models.CheckedOutBook checkedOutBook = new com.twu.biblioteca.models.CheckedOutBook(book, (User)session.getCurrentUser());
                checkedOutBooks.add(checkedOutBook);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookName) {
        com.twu.biblioteca.models.Book book = findBook(bookName, checkedOutBooks);
        if (book != null) {
            if (book.canBeReturned((User)session.getCurrentUser())) {
                checkedOutBooks.remove(book);
                com.twu.biblioteca.models.AvailableBook availableBook = new com.twu.biblioteca.models.AvailableBook(book);
                availableBooks.add(availableBook);
                return true;
            }
        }
        return false;
    }

    public boolean checkOutMovie(String movieName) {
        for (com.twu.biblioteca.models.Movie movie: movies) {
            if (movie.match(movieName)) {
                return movie.checkOut();
            }
        }
        return false;
    }
}
