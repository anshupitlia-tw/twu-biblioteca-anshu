package com.twu.biblioteca;

//The Bangalore Public Library Application
public class LibraryApplication {
    private UserInterface userInterface;
    private Messages messages;
    private Books books;

    public LibraryApplication(UserInterface userInterface, Messages messages, Books books) {
        this.userInterface = userInterface;
        this.messages = messages;
        this.books = books;
    }

    public void start() {
        userInterface.print(messages.getUXMessage("welcome_message"));
    }

    public void listBooks() {
        userInterface.print(books.getBookListForDisplay());
    }
}
