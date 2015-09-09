package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public String getBookListForDisplay() {
        String bookList = "NAME\tAUTHOR\tYEAR PUBLISHED\n";
        for(Book book: books) {
            bookList += book.getBookDetailsForDisplay();
        }
        return bookList;
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
