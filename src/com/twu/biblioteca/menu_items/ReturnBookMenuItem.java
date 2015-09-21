package com.twu.biblioteca.menu_items;

import com.twu.biblioteca.helpers.LoginCaller;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.user_interface.UserInterface;

public class ReturnBookMenuItem extends MenuItem {

    private Library library;
    private String bookName;
    private UserInterface userInterface;
    private Messages messages;
    private LoginCaller loginCaller;

    public ReturnBookMenuItem(String name, Library library, UserInterface userInterface, LoginCaller loginCaller, Messages messages) {
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
