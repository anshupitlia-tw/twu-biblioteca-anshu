package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParserTest {

    @Test
    public void shouldReturnTrueForAValidMenuChoice() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = new Parser(userInterface, messages, library, mainMenu);

        when(mainMenu.hasMenu(1)).thenReturn(true);
        assertEquals(true, parser.isValidMenuChoice(1));
    }

    @Test
    public void shouldReturnFalseForAnInvalidValidMenuChoice() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = new Parser(userInterface, messages, library, mainMenu);

        when(mainMenu.hasMenu(0)).thenReturn(false);
        assertEquals(false, parser.isValidMenuChoice(0));
    }

    @Test
    public void shouldReturnTrueIfItIsQuitting() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = new Parser(userInterface, messages, library, mainMenu);

        when(mainMenu.getMenu(2)).thenReturn("Quit");
        when(messages.getUXMessage("quit_option")).thenReturn("Quit");

        assertEquals(true, parser.isQuitting(2));
    }

    @Test
    public void shouldDelegateToListBooksMenuIfUserGoesForListingBooks() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = new Parser(userInterface, messages, library, mainMenu);

        when(mainMenu.hasMenu(1)).thenReturn(true);
        when(mainMenu.getMenu(1)).thenReturn("List Books");
        when(messages.getUXMessage("list_books")).thenReturn("List Books");
        when(messages.getUXMessage("quit_option")).thenReturn("Quit");
        AMenu assignedMenu = parser.assignADelegateMenu(1);

        assertEquals(assignedMenu.getClass(), ListBooksMenu.class);
    }

    @Test
    public void shouldDelegateToInvalidMenuIfUserGoesForInvalidOption() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = new Parser(userInterface, messages, library, mainMenu);

        when(mainMenu.hasMenu(0)).thenReturn(false);

        AMenu assignedMenu = parser.assignADelegateMenu(0);
        assertEquals(assignedMenu.getClass(), InvalidMenu.class);
    }

    @Test
    public void shouldDelegateToQuitMenuIfUserGoesForQuitOption() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = new Parser(userInterface, messages, library, mainMenu);

        when(mainMenu.hasMenu(2)).thenReturn(true);
        when(mainMenu.getMenu(2)).thenReturn("Quit");
        when(messages.getUXMessage("list_books")).thenReturn("List Books");
        when(messages.getUXMessage("quit_option")).thenReturn("Quit");

        AMenu assignedMenu = parser.assignADelegateMenu(2);
        assertEquals(assignedMenu.getClass(), QuitMenu.class);
    }
}
