package com.twu.biblioteca.menu_items;

import com.twu.biblioteca.helpers.LoginCaller;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.user_interface.UserInterface;

public class CheckedOutBookDetailsMenuItem extends MenuItem {
    private UserInterface userInterface;
    private Library library;
    private LoginCaller loginCaller;

    public CheckedOutBookDetailsMenuItem(String name, UserInterface userInterface, Library library, LoginCaller loginCaller) {
        this.name = name;
        this.userInterface = userInterface;
        this.library = library;
        this.loginCaller = loginCaller;
    }
    @Override
    public void execute() {
        if (loginCaller.callLoginViewForLibrarian()) {
            userInterface.printOnOutputStream(library.getCheckedOutBookDetailsForDisplay());
        }
    }
}
