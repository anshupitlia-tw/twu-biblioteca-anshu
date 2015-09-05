package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.mockito.Mockito.*;

public class LibraryApplicationTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldStartWithAWelcomeMessageAndPrintItOnTheUserInterface() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);

        when(messages.getUXMessage("welcome_message")).thenReturn("Welcome! Biblioteca at your service");

        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, library, mainMenu);
        libraryApplication.start();

        verify(userInterface, times(1)).print("Welcome! Biblioteca at your service");
    }

    @Test
    public void shouldDisplayTheMainMenuList() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);
        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, library, mainMenu);
        when(mainMenu.getListOfMenuForDisplay()).thenReturn("1. List Books");

        libraryApplication.listMainMenu();

        verify(userInterface, times(1)).print(mainMenu.getListOfMenuForDisplay());
    }

    @Test
    public void shouldDisplayTheListOfBooksOnUserInterfaceWhenUserSelectsToDisplayListBooks() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);

        when(library.getBookListForDisplay()).thenReturn("Book1\nBook2");
        when(mainMenu.getMenu(1)).thenReturn("List Books");
        when(messages.getUXMessage("list_books")).thenReturn("List Books");

        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, library, mainMenu);
        libraryApplication.parse(1);

        verify(userInterface, times(1)).print("Book1\nBook2");
    }

    @Test
    public void shouldAskUserForInputAgainAndAgainUntilValidOptionComes() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);

        when(userInterface.getMenuChoice()).thenReturn(0).thenReturn(1);
        when(mainMenu.hasMenu(0)).thenReturn(false);
        when(mainMenu.hasMenu(1)).thenReturn(true);
        when(messages.getUXMessage("select_a_valid_option")).thenReturn("Select a valid option!");

        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, library, mainMenu);
        libraryApplication.getUserChoice();

        verify(userInterface, times(1)).print("Select a valid option!");
    }

    @Test
    public void shouldBeAbleToExitTheApplicationOnQuit() {
        exit.expectSystemExitWithStatus(0);
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);

        when(mainMenu.getMenu(2)).thenReturn("Quit");
        when(messages.getUXMessage("quit_option")).thenReturn("Quit");

        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, library, mainMenu);
        libraryApplication.parse(2);
    }
}
