package com.twu.biblioteca;

public class CheckedOutBookDetailsMenuItem extends MenuItem{
    private UserInterface userInterface;
    private Library library;
    private LoginCaller loginCaller;

    CheckedOutBookDetailsMenuItem(String name, UserInterface userInterface, Library library, LoginCaller loginCaller) {
        this.name = name;
        this.userInterface = userInterface;
        this.library = library;
        this.loginCaller = loginCaller;
    }
    @Override
    public void execute() {
        if (loginCaller.callLoginViewForUser()) {
            userInterface.printOnOutputStream(library.getCheckedOutBookDetails());
        }
    }
}
