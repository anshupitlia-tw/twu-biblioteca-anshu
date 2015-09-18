package com.twu.biblioteca;

import java.util.HashMap;

public class MessageFactory{
    private Messages messages;

    public Messages establishMessages() {
        HashMap<String, String> setUpMessages = new HashMap<>();
        setUpMessages.put("welcome_message", "Welcome! Biblioteca at your service");
        setUpMessages.put("list_books", "List Books");
        setUpMessages.put("select_a_valid_option", "Select a valid option!");
        setUpMessages.put("quit_option", "Quit");
        setUpMessages.put("checkout_book", "Checkout A Book");
        setUpMessages.put("return_book", "Return A Book");
        setUpMessages.put("successful_checkout", "Thank you! Enjoy the book");
        setUpMessages.put("unsuccessful_checkout", "That book is not available. Please select a different book, or fix the spelling error");
        setUpMessages.put("enter_book_name", "Enter the book name");
        setUpMessages.put("successful_return", "Thank you for returning the book.");
        setUpMessages.put("unsuccessful_return", "That is not a valid book to return.");
        setUpMessages.put("list_movies", "List Movies");
        setUpMessages.put("enter_movie_name", "Enter Movie Name");
        setUpMessages.put("checkout_movie", "Checkout A Movie");
        setUpMessages.put("enter_library_number", "Enter Library Number");
        setUpMessages.put("enter_password", "Enter Password");
        setUpMessages.put("login", "Login");
        setUpMessages.put("logout", "Logout");
        setUpMessages.put("view_details", "View Details");
        messages = new Messages(setUpMessages);
        return messages;
    }
}
