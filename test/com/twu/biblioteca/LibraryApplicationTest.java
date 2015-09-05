package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class LibraryApplicationTest {

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
        when(userInterface.getMenuChoice()).thenReturn(1);
        when(mainMenu.getMenu(1)).thenReturn("List Books");
        when(messages.getUXMessage("list_books")).thenReturn("List Books");

        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, library, mainMenu);
        libraryApplication.getUserChoice();

        verify(userInterface, times(1)).print("Book1\nBook2");
    }
}
