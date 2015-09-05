package com.twu.biblioteca;

import java.util.List;

public class Library {
    List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public String getBookListForDisplay() {
        String bookList = "NAME\tAUTHOR\tYEAR PUBLISHED\n";
        for(Book book: books) {
            bookList += book.getBookDetailsForDisplay() + "\n";
        }
        return bookList;
    }
}
