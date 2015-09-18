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
    public abstract String getBookDetailsForDisplay();


    public boolean match(String bookName) {
        return title.equals(bookName);
    }

    public abstract boolean checkOutBook();

    public abstract boolean returnBook();

    public abstract String getCheckedOutDetailsForDisplay();
}
