package com.twu.biblioteca;

public class CheckoutBookMenu implements AMenu{
    private Library library;
    private String bookName;
    private UserInterface userInterface;
    private Messages messages;

    CheckoutBookMenu(Library library, String bookName, UserInterface userInterface, Messages messages) {
        this.library = library;
        this.bookName = bookName;
        this.userInterface = userInterface;
        this.messages = messages;
    }
    @Override
    public void execute() {
        if (library.findTheBookAndCheckout(bookName)) {
            userInterface.print(messages.getUXMessage("successful_checkout"));
        }
        else {
            userInterface.print(messages.getUXMessage("unsuccessful_checkout"));
        }
    }
}
