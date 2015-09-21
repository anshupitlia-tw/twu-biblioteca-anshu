package com.twu.biblioteca.menu_items;

import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.user_interface.UserInterface;

public class CheckoutMovieMenuItem extends MenuItem {
    private Library library;
    private String movieName;
    private UserInterface userInterface;
    private Messages messages;

    public CheckoutMovieMenuItem(String name, Library library, UserInterface userInterface, Messages messages) {
        this.name = name;
        this.library = library;
        this.userInterface = userInterface;
        this.messages = messages;
    }

    @Override
    public void execute() {
        userInterface.printOnOutputStream(messages.getUXMessage("enter_movie_name"));
        movieName = userInterface.getChoiceFromUser();
        if (library.checkOutMovie(movieName)) {
            userInterface.printOnOutputStream(messages.getUXMessage("successful_checkout_movie"));
        } else {
            userInterface.printOnOutputStream(messages.getUXMessage("unsuccessful_checkout_movie"));
        }
    }
}
