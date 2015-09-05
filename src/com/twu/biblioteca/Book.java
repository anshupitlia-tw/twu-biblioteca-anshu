package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private short yearPublished;

    public Book(String name, String author, short yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getBookDetailsForDisplay() {
       return this.name + "\t" + this.author + "\t" + this.yearPublished;
    }
}
