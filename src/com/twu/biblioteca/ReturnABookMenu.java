package com.twu.biblioteca;

public class ReturnABookMenu implements AMenu{

    private Library library;
    private String bookName;
    private UserInterface userInterface;
    private Messages messages;

    ReturnABookMenu(Library library, UserInterface userInterface, Messages messages) {
        this.library = library;
        this.userInterface = userInterface;
        this.messages = messages;
    }
    @Override
    public void execute() {
        userInterface.print(messages.getUXMessage("enter_book_name"));
        bookName = userInterface.getBookName();
        if (library.returnBook(bookName)) {
            userInterface.print(messages.getUXMessage("successful_return"));
        }
        else
        {
            userInterface.print(messages.getUXMessage("unsuccessful_return"));
        }
    }

}
