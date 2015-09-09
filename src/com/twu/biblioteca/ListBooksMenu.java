package com.twu.biblioteca;

public class ListBooksMenu extends AMenu{
    private UserInterface userInterface;
    private Library library;

    ListBooksMenu(String name, UserInterface userInterface, Library library) {
        this.name = name;
        this.userInterface = userInterface;
        this.library = library;
    }
    @Override
    public void execute() {
        userInterface.print(library.getBookListForDisplay());
    }
}
