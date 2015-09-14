
package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParserTest {

    @Test
    public void shouldReturnTrueForAValidMenuChoice() {
        InvalidMenuItem invalidMenuItem = mock(InvalidMenuItem.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = new Parser(invalidMenuItem, mainMenu);

        when(mainMenu.hasMenu(1)).thenReturn(true);
        assertEquals(true, parser.isValidMenuChoice(1));
    }

    @Test
    public void shouldReturnFalseForAnInvalidValidMenuChoice() {
        InvalidMenuItem invalidMenuItem = mock(InvalidMenuItem.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = new Parser(invalidMenuItem, mainMenu);

        when(mainMenu.hasMenu(0)).thenReturn(false);
        assertEquals(false, parser.isValidMenuChoice(0));
    }

    @Test
    public void shouldReturnTrueIfItIsQuitting() {
        InvalidMenuItem invalidMenuItem = mock(InvalidMenuItem.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = new Parser(invalidMenuItem, mainMenu);

        when(mainMenu.getMenu(2)).thenReturn(new QuitMenuItem("Quit"));

        assertEquals(true, parser.isQuitting(2));
    }

    @Test
    public void shouldDelegateToListBooksMenuIfUserGoesForListingBooks() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);
        InvalidMenuItem invalidMenuItem = mock(InvalidMenuItem.class);
        Parser parser = new Parser(invalidMenuItem, mainMenu);

        when(mainMenu.hasMenu(1)).thenReturn(true);
        when(mainMenu.getMenu(1)).thenReturn(new ListBooksMenuItem("List Books", userInterface,library));
        when(messages.getUXMessage("list_books")).thenReturn("List Books");
        when(messages.getUXMessage("quit_option")).thenReturn("Quit");
        MenuItem assignedMenuItem = parser.assignADelegateMenu(1);

        assertEquals(assignedMenuItem.getClass(), ListBooksMenuItem.class);
    }

    @Test
    public void shouldDelegateToInvalidMenuIfUserGoesForInvalidOption() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        MainMenu mainMenu = mock(MainMenu.class);
        InvalidMenuItem invalidMenuItem = new InvalidMenuItem(userInterface, messages);
        Parser parser = new Parser(invalidMenuItem, mainMenu);

        when(mainMenu.hasMenu(0)).thenReturn(false);

        MenuItem assignedMenuItem = parser.assignADelegateMenu(0);
        assertEquals(assignedMenuItem.getClass(), InvalidMenuItem.class);
    }

    @Test
    public void shouldDelegateToQuitMenuIfUserGoesForQuitOption() {
        Messages messages = mock(Messages.class);
        MainMenu mainMenu = mock(MainMenu.class);
        InvalidMenuItem invalidMenuItem = mock(InvalidMenuItem.class);
        Parser parser = new Parser(invalidMenuItem, mainMenu);

        when(mainMenu.hasMenu(2)).thenReturn(true);
        when(mainMenu.getMenu(2)).thenReturn(new QuitMenuItem("Quit"));
        when(messages.getUXMessage("list_books")).thenReturn("List Books");
        when(messages.getUXMessage("quit_option")).thenReturn("Quit");

        MenuItem assignedMenuItem = parser.assignADelegateMenu(2);
        assertEquals(assignedMenuItem.getClass(), QuitMenuItem.class);
    }

    @Test
    public void shouldDelegateToCheckoutMenuIfUserGoesForCheckoutOption() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);
        InvalidMenuItem invalidMenuItem = mock(InvalidMenuItem.class);
        Parser parser = new Parser(invalidMenuItem, mainMenu);

        when(mainMenu.hasMenu(3)).thenReturn(true);
        when(mainMenu.getMenu(3)).thenReturn(new CheckoutBookMenuItem("Checkout A Book", library, userInterface, messages));
        when(messages.getUXMessage("checkout_book")).thenReturn("Checkout A Book");
        when(userInterface.getAStringFromUser()).thenReturn("Anna Karenina");

        MenuItem assignedMenuItem = parser.assignADelegateMenu(3);
        assertEquals(assignedMenuItem.getClass(), CheckoutBookMenuItem.class);
    }

    @Test
    public void shouldDelegateToReturnABookMenuIfUserGoesForReturnABookOption() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);
        InvalidMenuItem invalidMenuItem = mock(InvalidMenuItem.class);
        Parser parser = new Parser(invalidMenuItem, mainMenu);

        when(mainMenu.hasMenu(4)).thenReturn(true);
        when(mainMenu.getMenu(4)).thenReturn(new ReturnBookMenuItem("Return A Book", library, userInterface, messages));
        when(messages.getUXMessage("return_book")).thenReturn("Return A Book");
        when(userInterface.getAStringFromUser()).thenReturn("Anna Karenina");

        MenuItem assignedMenuItem = parser.assignADelegateMenu(4);
        assertEquals(assignedMenuItem.getClass(), ReturnBookMenuItem.class);
    }
}

