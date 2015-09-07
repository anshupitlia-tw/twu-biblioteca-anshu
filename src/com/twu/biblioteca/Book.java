package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private short yearPublished;
    private boolean isAvailable;

    public Book(String name, String author, short yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        isAvailable = true;
    }

    public String getBookDetailsForDisplay() {
        if (isAvailable) {
            return this.name + "\t" + this.author + "\t" + this.yearPublished;
        }
        else return "";
    }

    public boolean match(String bookName) {
        return name.equals(bookName);
    }

    public boolean checkOut() {
        if (isAvailable == true) {
            isAvailable = false;
            return true;
        } else
        {
            return false;
        }
    }
}
