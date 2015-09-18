package com.twu.biblioteca;

public class CheckedOutBook extends Book{

    private User checkedOutBy;

    public CheckedOutBook(String name, String author, short yearPublished, User checkedOutBy) {
        super(name, author, yearPublished);
        this.checkedOutBy = checkedOutBy;
    }

    public CheckedOutBook(Book book, User checkedOutBy) {
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
