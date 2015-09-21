package com.twu.biblioteca.menu_items;

public class CheckedOutBookDetailsMenuItem extends MenuItem {
    private com.twu.biblioteca.user_interface.UserInterface userInterface;
    private com.twu.biblioteca.models.Library library;
    private com.twu.biblioteca.helpers.LoginCaller loginCaller;

    public CheckedOutBookDetailsMenuItem(String name, com.twu.biblioteca.user_interface.UserInterface userInterface, com.twu.biblioteca.models.Library library, com.twu.biblioteca.helpers.LoginCaller loginCaller) {
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
