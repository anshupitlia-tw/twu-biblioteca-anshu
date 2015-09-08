package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private short yearPublished;
    private boolean isAvailable;

    public Book(String name, String author, short yearPublished) {
        this.title = name;
        this.author = author;
        this.yearPublished = yearPublished;
        isAvailable = true;
    }

    public String getBookDetailsForDisplay() {
        if (isAvailable) {
            return this.title + "\t" + this.author + "\t" + this.yearPublished+ "\n";
        }
        else return "";
    }

    public boolean match(String bookName) {
        return title.equals(bookName);
    }

    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        } else
        {
            return false;
        }
    }

    public boolean returnn() {
        if (!isAvailable) {
            isAvailable = true;
            return true;
        } else
        {
            return false;
        }
    }
}
