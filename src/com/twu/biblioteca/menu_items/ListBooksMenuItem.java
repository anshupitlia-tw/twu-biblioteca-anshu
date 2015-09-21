package com.twu.biblioteca.menu_items;

import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.user_interface.UserInterface;

public class ListBooksMenuItem extends MenuItem {
    private UserInterface userInterface;
    private Library library;

    public ListBooksMenuItem(String name, UserInterface userInterface, Library library) {
        this.name = name;
        this.userInterface = userInterface;
        this.library = library;
    }
    @Override
    public void execute() {
        userInterface.printOnOutputStream(library.getAvailableBookListForDisplay());
    }
}
