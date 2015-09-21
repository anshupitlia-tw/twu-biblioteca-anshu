package com.twu.biblioteca.menu_items;

public class ReturnBookMenuItem extends MenuItem {

    private com.twu.biblioteca.models.Library library;
    private String bookName;
    private com.twu.biblioteca.user_interface.UserInterface userInterface;
    private com.twu.biblioteca.helpers.Messages messages;
    private com.twu.biblioteca.helpers.LoginCaller loginCaller;

    public ReturnBookMenuItem(String name, com.twu.biblioteca.models.Library library, com.twu.biblioteca.user_interface.UserInterface userInterface, com.twu.biblioteca.helpers.LoginCaller loginCaller, com.twu.biblioteca.helpers.Messages messages) {
        this.name = name;
        this.library = library;
        this.userInterface = userInterface;
        this.loginCaller = loginCaller;
        this.messages = messages;
    }
    @Override
    public void execute() {
        if (loginCaller.callLoginViewForUser()) {
            userInterface.printOnOutputStream(messages.getUXMessage("enter_book_name"));
            bookName = userInterface.getChoiceFromUser();
            if (library.returnBook(bookName)) {
                userInterface.printOnOutputStream(messages.getUXMessage("successful_return"));
            } else {
                userInterface.printOnOutputStream(messages.getUXMessage("unsuccessful_return"));
            }
        }
    }
}
