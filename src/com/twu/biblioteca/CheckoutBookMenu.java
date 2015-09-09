package com.twu.biblioteca;

public class CheckoutBookMenu implements AMenu{
    private Library library;
    private String bookName;
    private UserInterface userInterface;
    private Messages messages;

    CheckoutBookMenu(Library library, UserInterface userInterface, Messages messages) {
        this.library = library;
        this.userInterface = userInterface;
        this.messages = messages;
    }

    @Override
    public void execute() {
        userInterface.print(messages.getUXMessage("enter_book_name"));
        bookName = userInterface.getBookName();
        if (library.checkOutBook(bookName)) {
            userInterface.print(messages.getUXMessage("successful_checkout"));
        }
        else {
            userInterface.print(messages.getUXMessage("unsuccessful_checkout"));
        }
    }
}
