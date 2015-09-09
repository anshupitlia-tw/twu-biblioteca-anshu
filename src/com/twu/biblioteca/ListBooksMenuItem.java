package com.twu.biblioteca;

public class ListBooksMenuItem extends MenuItem {
    private UserInterface userInterface;
    private Library library;

    ListBooksMenuItem(String name, UserInterface userInterface, Library library) {
        this.name = name;
        this.userInterface = userInterface;
        this.library = library;
    }
    @Override
    public void execute() {
        userInterface.print(library.getBookListForDisplay());
    }
}
