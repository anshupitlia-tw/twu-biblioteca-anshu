package com.twu.biblioteca;

public class CheckoutBookMenuItem extends MenuItem {
    private Library library;
    private String bookName;
    private UserInterface userInterface;
    private Messages messages;

    CheckoutBookMenuItem(String name, Library library, UserInterface userInterface, Messages messages) {
        this.name = name;
        this.library = library;
        this.userInterface = userInterface;
        this.messages = messages;
    }

    @Override
    public void execute() {
        userInterface.printOnOutputStream(messages.getUXMessage("enter_book_name"));
        bookName = userInterface.getChoiceFromUser();
        if (library.checkOutBook(bookName)) {
            userInterface.printOnOutputStream(messages.getUXMessage("successful_checkout"));
        }
        else {
            userInterface.printOnOutputStream(messages.getUXMessage("unsuccessful_checkout"));
        }
    }
}
