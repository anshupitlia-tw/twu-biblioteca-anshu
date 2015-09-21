package com.twu.biblioteca.models;

import com.twu.biblioteca.authentication.User;

public class AvailableBook extends Book {

    public AvailableBook(String title, String author, short yearPublished) {
        super(title, author, yearPublished);
    }

    public AvailableBook(Book book) {
        super (book);
    }

    @Override
    public String getAvailableBookDetailsForDisplay() {
        StringBuilder bookDetails = new StringBuilder();
        bookDetails.append(String.format("%-40s%-40s%-40s\n", this.title, this.author, this.yearPublished));
        return bookDetails.toString();
    }

    @Override
    public boolean canBeCheckedOut() {
        return true;
    }

    @Override
    public boolean canBeReturned(User thatUser) {
        return false;
    }

    @Override
    public String getCheckedOutBookDetailsForDisplay() {
        StringBuilder bookDetails = new StringBuilder();
        return bookDetails.toString();
    }
}
