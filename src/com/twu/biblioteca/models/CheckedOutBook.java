package com.twu.biblioteca.models;

import com.twu.biblioteca.authentication.User;

public class CheckedOutBook extends com.twu.biblioteca.models.Book {

    private User checkedOutBy;

    public CheckedOutBook(String name, String author, short yearPublished, User checkedOutBy) {
        super(name, author, yearPublished);
        this.checkedOutBy = checkedOutBy;
    }

    public CheckedOutBook(com.twu.biblioteca.models.Book book, User checkedOutBy) {
        super(book);
        this.checkedOutBy = checkedOutBy;
    }

    public String getAvailableBookDetailsForDisplay() {
        StringBuilder bookDetails = new StringBuilder();
        return bookDetails.toString();
        }

        public boolean canBeCheckedOut() {
        return false;
        }

        public boolean canBeReturned(User user) {
            if (checkedOutBy.equals(user))
                return true;
            else
                return false;
    }


    public String getCheckedOutBookDetailsForDisplay() {
        StringBuilder stringBuilder = new StringBuilder().append(String.format("%-40s%-40s\n", title, checkedOutBy.getLibraryNumber()));
        return stringBuilder.toString();
    }
}
