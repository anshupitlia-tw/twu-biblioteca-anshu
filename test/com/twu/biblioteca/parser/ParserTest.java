
package com.twu.biblioteca.parser;

import com.twu.biblioteca.helpers.Messages;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParserTest {

    @Test
    public void shouldReturnTrueForAValidMenuChoice() {
        com.twu.biblioteca.menu_items.InvalidMenuItem invalidMenuItem = mock(com.twu.biblioteca.menu_items.InvalidMenuItem.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = mock(com.twu.biblioteca.main_menu.MainMenu.class);
        com.twu.biblioteca.parser.Parser parser = new com.twu.biblioteca.parser.Parser(invalidMenuItem, mainMenu);

        when(mainMenu.hasMenu("1")).thenReturn(true);
        assertEquals(true, parser.isValidMenuChoice("1"));
    }

    @Test
    public void shouldReturnFalseForAnInvalidValidMenuChoice() {
        com.twu.biblioteca.menu_items.InvalidMenuItem invalidMenuItem = mock(com.twu.biblioteca.menu_items.InvalidMenuItem.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = mock(com.twu.biblioteca.main_menu.MainMenu.class);
        com.twu.biblioteca.parser.Parser parser = new com.twu.biblioteca.parser.Parser(invalidMenuItem, mainMenu);

        when(mainMenu.hasMenu("0")).thenReturn(false);
        assertEquals(false, parser.isValidMenuChoice("0"));
    }

    @Test
    public void shouldReturnTrueIfItIsQuitting() {
        com.twu.biblioteca.menu_items.InvalidMenuItem invalidMenuItem = mock(com.twu.biblioteca.menu_items.InvalidMenuItem.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = mock(com.twu.biblioteca.main_menu.MainMenu.class);
        com.twu.biblioteca.parser.Parser parser = new com.twu.biblioteca.parser.Parser(invalidMenuItem, mainMenu);

        when(mainMenu.getMenu("2")).thenReturn(new com.twu.biblioteca.menu_items.QuitMenuItem("Quit"));

        assertEquals(true, parser.isQuitting("2"));
    }

    @Test
    public void shouldDelegateToListBooksMenuIfUserGoesForListingBooks() {
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = mock(com.twu.biblioteca.main_menu.MainMenu.class);
        com.twu.biblioteca.menu_items.InvalidMenuItem invalidMenuItem = mock(com.twu.biblioteca.menu_items.InvalidMenuItem.class);
        com.twu.biblioteca.parser.Parser parser = new com.twu.biblioteca.parser.Parser(invalidMenuItem, mainMenu);

        when(mainMenu.hasMenu("1")).thenReturn(true);
        when(mainMenu.getMenu("1")).thenReturn(new com.twu.biblioteca.menu_items.ListBooksMenuItem("List Books", userInterface,library));
        when(messages.getUXMessage("list_books")).thenReturn("List Books");
        when(messages.getUXMessage("quit_option")).thenReturn("Quit");
        com.twu.biblioteca.menu_items.MenuItem assignedMenuItem = parser.assignADelegateMenu("1");

        assertEquals(assignedMenuItem.getClass(), com.twu.biblioteca.menu_items.ListBooksMenuItem.class);
    }

    @Test
    public void shouldDelegateToInvalidMenuIfUserGoesForInvalidOption() {
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = mock(com.twu.biblioteca.main_menu.MainMenu.class);
        com.twu.biblioteca.menu_items.InvalidMenuItem invalidMenuItem = new com.twu.biblioteca.menu_items.InvalidMenuItem(userInterface, messages);
        com.twu.biblioteca.parser.Parser parser = new com.twu.biblioteca.parser.Parser(invalidMenuItem, mainMenu);

        when(mainMenu.hasMenu("0")).thenReturn(false);

        com.twu.biblioteca.menu_items.MenuItem assignedMenuItem = parser.assignADelegateMenu("0");
        assertEquals(assignedMenuItem.getClass(), com.twu.biblioteca.menu_items.InvalidMenuItem.class);
    }

    @Test
    public void shouldDelegateToQuitMenuIfUserGoesForQuitOption() {
        com.twu.biblioteca.helpers.Messages messages = mock(Messages.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = mock(com.twu.biblioteca.main_menu.MainMenu.class);
        com.twu.biblioteca.menu_items.InvalidMenuItem invalidMenuItem = mock(com.twu.biblioteca.menu_items.InvalidMenuItem.class);
        com.twu.biblioteca.parser.Parser parser = new com.twu.biblioteca.parser.Parser(invalidMenuItem, mainMenu);

        when(mainMenu.hasMenu("2")).thenReturn(true);
        when(mainMenu.getMenu("2")).thenReturn(new com.twu.biblioteca.menu_items.QuitMenuItem("Quit"));
        when(messages.getUXMessage("list_books")).thenReturn("List Books");
        when(messages.getUXMessage("quit_option")).thenReturn("Quit");

        com.twu.biblioteca.menu_items.MenuItem assignedMenuItem = parser.assignADelegateMenu("2");
        assertEquals(assignedMenuItem.getClass(), com.twu.biblioteca.menu_items.QuitMenuItem.class);
    }

    @Test
    public void shouldDelegateToCheckoutMenuIfUserGoesForCheckoutOption() {
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = mock(com.twu.biblioteca.main_menu.MainMenu.class);
        com.twu.biblioteca.menu_items.InvalidMenuItem invalidMenuItem = mock(com.twu.biblioteca.menu_items.InvalidMenuItem.class);
        com.twu.biblioteca.parser.Parser parser = new com.twu.biblioteca.parser.Parser(invalidMenuItem, mainMenu);
        com.twu.biblioteca.helpers.LoginCaller loginCaller = mock(com.twu.biblioteca.helpers.LoginCaller.class);

        when(mainMenu.hasMenu("3")).thenReturn(true);
        when(mainMenu.getMenu("3")).thenReturn(new com.twu.biblioteca.menu_items.CheckoutBookMenuItem("Checkout A Book", library, userInterface, loginCaller, messages));
        when(messages.getUXMessage("checkout_book")).thenReturn("Checkout A Book");
        when(userInterface.getChoiceFromUser()).thenReturn("Anna Karenina");

        com.twu.biblioteca.menu_items.MenuItem assignedMenuItem = parser.assignADelegateMenu("3");
        assertEquals(assignedMenuItem.getClass(), com.twu.biblioteca.menu_items.CheckoutBookMenuItem.class);
    }

    @Test
    public void shouldDelegateToReturnABookMenuIfUserGoesForReturnABookOption() {
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = mock(com.twu.biblioteca.main_menu.MainMenu.class);
        com.twu.biblioteca.menu_items.InvalidMenuItem invalidMenuItem = mock(com.twu.biblioteca.menu_items.InvalidMenuItem.class);
        com.twu.biblioteca.parser.Parser parser = new com.twu.biblioteca.parser.Parser(invalidMenuItem, mainMenu);
        com.twu.biblioteca.helpers.LoginCaller loginCaller = mock(com.twu.biblioteca.helpers.LoginCaller.class);

        when(mainMenu.hasMenu("4")).thenReturn(true);
        when(mainMenu.getMenu("4")).thenReturn(new com.twu.biblioteca.menu_items.ReturnBookMenuItem("Return A Book", library, userInterface, loginCaller, messages));
        when(messages.getUXMessage("return_book")).thenReturn("Return A Book");
        when(userInterface.getChoiceFromUser()).thenReturn("Anna Karenina");

        com.twu.biblioteca.menu_items.MenuItem assignedMenuItem = parser.assignADelegateMenu("4");
        assertEquals(assignedMenuItem.getClass(), com.twu.biblioteca.menu_items.ReturnBookMenuItem.class);
    }
}


