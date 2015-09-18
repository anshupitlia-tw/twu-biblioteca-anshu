package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> availableBooks;
    private List<Book> checkedOutBooks;
    private List<Movie> movies;
    private Session session;

    public Library(List<Book> availableBooks, List<Movie> movies, Session session) {
        this.availableBooks = availableBooks;
        this.movies = movies;
        this.session = session;
        this.checkedOutBooks = new ArrayList<>();
    }

    public String getCheckedOutBookDetailsForDisplay() {
        StringBuilder checkedOutBookList = new StringBuilder().append(String.format("%-40s%-40s\n", "BOOK NAME", "CHECKED OUT BY"));
        for (Book book: checkedOutBooks) {
            checkedOutBookList.append(book.getCheckedOutBookDetailsForDisplay());
        }
        return checkedOutBookList.toString();
    }

    public String getMovieListForDisplay() {
        StringBuilder movieList = new StringBuilder().append(String.format("%-40s%-40s%-40s%-40s\n", "NAME", "YEAR RELEASED", "DIRECTOR", "RATING"));
        for(Movie movie: movies) {
            movieList.append(movie.getMovieDetailsForDisplay());
        }
        return movieList.toString();
    }

    public String getAvailableBookListForDisplay() {
        StringBuilder bookList = new StringBuilder().append(String.format("%-40s%-40s%-40s\n", "NAME", "AUTHOR", "YEAR PUBLISHED"));
        for(Book book: availableBooks) {
            bookList.append(book.getAvailableBookDetailsForDisplay());
        }
        return bookList.toString();
    }

    private Book findBook(String bookName, List<Book> bookList) {
        for (Book book : bookList) {
            if (book.match(bookName)) {
                return book;
            }
        }
        return null;
    }

    public boolean checkOutBook(String bookName) {
        Book book = findBook(bookName, availableBooks);
        if (book != null) {
            if (book.canBeCheckedOut()) {
                availableBooks.remove(book);
                CheckedOutBook checkedOutBook = new CheckedOutBook(book, (User)session.getCurrentUser());
                checkedOutBooks.add(checkedOutBook);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookName) {
        Book book = findBook(bookName, checkedOutBooks);
        if (book != null) {
            if (book.canBeReturned((User)session.getCurrentUser())) {
                checkedOutBooks.remove(book);
                AvailableBook availableBook = new AvailableBook(book);
                availableBooks.add(availableBook);
                return true;
            }
        }
        return false;
    }

    public void checkOutMovie(String movieName) {
        for (Movie movie: movies) {
            if(movie.match(movieName)) {
                movie.checkOut();
            }
        }
    }
}
