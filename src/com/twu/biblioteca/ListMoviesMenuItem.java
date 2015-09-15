package com.twu.biblioteca;

public class ListMoviesMenuItem extends MenuItem{
    private UserInterface userInterface;
    private Library library;

    ListMoviesMenuItem(String name, UserInterface userInterface, Library library) {
        this.name = name;
        this.userInterface = userInterface;
        this.library = library;
    }
    @Override
    public void execute() {
        userInterface.printOnOutputStream(library.getMovieListForDisplay());
    }
}
