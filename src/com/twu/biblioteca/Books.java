package com.twu.biblioteca;

import java.util.List;

public class Books {
    List<String> books;

    public Books(List<String> books) {
        this.books = books;
    }

    public String getBookListForDisplay() {
        String bookList = "";
        for(String book: books) {
            bookList += book + "\n";
        }
        return bookList;
    }
}
