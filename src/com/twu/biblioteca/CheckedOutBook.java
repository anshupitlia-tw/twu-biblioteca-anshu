package com.twu.biblioteca;

public class CheckedOutBook extends Book{

    private User checkedOutBy;

    public CheckedOutBook(String name, String author, short yearPublished) {
        super(name, author, yearPublished);
    }

    public CheckedOutBook(Book book, Guest checkedOutBy) {
        super(book);
        this.checkedOutBy = (User)checkedOutBy;
    }

    public String getBookDetailsForDisplay() {
        StringBuilder bookDetails = new StringBuilder();
        return bookDetails.toString();
        }

        public boolean checkOutBook() {
        return false;
        }

        public boolean returnBook() {
            return true;
    }


    public String getCheckedOutDetailsForDisplay() {
        StringBuilder stringBuilder = new StringBuilder().append(String.format("%-40s%-40s", title, checkedOutBy.getLibraryNumber()));
        return stringBuilder.toString();
    }
}
