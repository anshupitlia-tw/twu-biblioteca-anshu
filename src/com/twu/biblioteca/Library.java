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

    public boolean findTheBookAndCheckout(String bookName) {
        boolean found = false, checkedOut = false;
        for (Book book: books) {
            if (book.match(bookName)) {
                found = true;
                checkedOut = book.checkOut();
                break;
            }
        }
        return found && checkedOut;
    }
}
