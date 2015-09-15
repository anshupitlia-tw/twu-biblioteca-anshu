package com.twu.biblioteca;

public class CheckoutMovieMenuItem extends MenuItem{
    private Library library;
    private String movieName;
    private UserInterface userInterface;
    private Messages messages;

    CheckoutMovieMenuItem(String name, Library library, UserInterface userInterface, Messages messages) {
        this.name = name;
        this.library = library;
        this.userInterface = userInterface;
        this.messages = messages;
    }

    @Override
    public void execute() {
        userInterface.printOnOutputStream(messages.getUXMessage("enter_movie_name"));
        movieName = userInterface.getChoiceFromUser();
        library.checkOutMovie(movieName);
    }
}
