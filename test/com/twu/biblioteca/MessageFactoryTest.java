package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MessageFactoryTest {
    private Messages messages;

    @Before
    public void setUp() {
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
        setUpMessages.put("view_user_profile", "View My Profile");
        setUpMessages.put("successful_checkout_movie", "Thank you! Enjoy the movie");
        setUpMessages.put("unsuccessful_checkout_movie", "That movie is not available. Please select a different movie, or fix the spelling error");
        messages = new Messages(setUpMessages);
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForWelcome() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("welcome_message"), messages.getUXMessage("welcome_message"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForListingBooks() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("list_books"), messages.getUXMessage("list_books"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForAskingAUserToSelectAValidOption() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("select_a_valid_option"), messages.getUXMessage("select_a_valid_option"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForQuittingOption() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("quit_option"), messages.getUXMessage("quit_option"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForCheckoutABookOption() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("checkout_book"), messages.getUXMessage("checkout_book"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForReturningABookOption() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("return_book"), messages.getUXMessage("return_book"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForSuccessfulCheckout() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("successful_checkout"), messages.getUXMessage("successful_checkout"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForUnsuccessfulCheckout() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("unsuccessful_checkout"), messages.getUXMessage("unsuccessful_checkout"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForAskingTheUserToEnterTheBookName() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("enter_book_name"), messages.getUXMessage("enter_book_name"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForSuccessfulReturn() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("successful_return"), messages.getUXMessage("successful_return"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForUnsuccessfulReturn() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("unsuccessful_return"), messages.getUXMessage("unsuccessful_return"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForListingMovies() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("list_movies"), messages.getUXMessage("list_movies"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForAskingToEnterMovieName() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("enter_movie_name"), messages.getUXMessage("enter_movie_name"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForMenuToCheckOutAMovie() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("checkout_movie"), messages.getUXMessage("checkout_movie"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForAskingTheUserToEnterLibraryNumber() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("enter_library_number"), messages.getUXMessage("enter_library_number"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForAskingTheUserToEnterPassword() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("enter_password"), messages.getUXMessage("enter_password"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForLogin() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("login"), messages.getUXMessage("login"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForViewingDetails() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("view_user_profile"), messages.getUXMessage("view_user_profile"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForSuccessfulCheckoutOfMovie() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("successful_checkout_movie"), messages.getUXMessage("successful_checkout_movie"));
    }

    @Test
    public void shouldCreateMessagesAndHaveTheSameMessageForUnsuccessfulCheckoutOfMovie() {
        MessageFactory messageFactory = new MessageFactory();

        assertEquals(messageFactory.establishMessages().getUXMessage("unsuccessful_checkout_movie"), messages.getUXMessage("unsuccessful_checkout_movie"));
    }
}

