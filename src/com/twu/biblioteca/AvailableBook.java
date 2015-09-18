package com.twu.biblioteca;

public class AvailableBook extends Book{

    public AvailableBook(String title, String author, short yearPublished) {
        super(title, author, yearPublished);
    }

    public AvailableBook(Book book) {
        super (book);
    }
    @Override
    public String getBookDetailsForDisplay() {
        StringBuilder bookDetails = new StringBuilder();
        bookDetails.append(String.format("%-40s%-40s%-40s\n", this.title,  this.author, this.yearPublished));
        return bookDetails.toString();
    }

    @Override
    public boolean checkOutBook() {
        return true;
    }

    @Override
    public boolean returnBook() {
        return false;
    }

    @Override
    public String getCheckedOutDetailsForDisplay() {
        return null;
    }
}
