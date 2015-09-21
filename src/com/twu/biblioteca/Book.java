package com.twu.biblioteca;

public abstract class Book {
    protected String title;
    protected String author;
    protected short yearPublished;

    public Book(String name, String author, short yearPublished) {
        this.title = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public Book(Book book) {
        this.title = book.title;
        this.author = book.author;
        this.yearPublished = book.yearPublished;
    }
    public abstract String getAvailableBookDetailsForDisplay();

    public boolean match(String bookName) {
        return title.toLowerCase().equals(bookName.toLowerCase());
    }

    public abstract boolean canBeCheckedOut();

    public abstract boolean canBeReturned(User user);

    public abstract String getCheckedOutBookDetailsForDisplay();
}
