package com.twu.biblioteca;

public class ListBooksMenu implements AMenu{
    private UserInterface userInterface;
    private Library library;

    ListBooksMenu(UserInterface userInterface, Library library) {
        this.userInterface = userInterface;
        this.library = library;
    }
    @Override
    public void execute() {
        userInterface.print(library.getBookListForDisplay());
    }
}
