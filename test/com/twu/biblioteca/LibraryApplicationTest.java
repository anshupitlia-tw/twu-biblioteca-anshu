package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.junit.Assert.assertEquals;
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
    public void shouldReturnTrueIfNeedToGetUserChoiceAgainOnInvalidChoice() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = mock(Parser.class);
        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, library, mainMenu);

        when(parser.isValidMenuChoice(0)).thenReturn(false);

        assertEquals(true, libraryApplication.shouldGetChoiceAgain(0, parser));
    }

    @Test
    public void shouldReturnTrueIfNeedToGetUserChoiceAgainIfNotQuitting() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = mock(Parser.class);
        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, library, mainMenu);

        when(parser.isQuitting(1)).thenReturn(false);

        assertEquals(true, libraryApplication.shouldGetChoiceAgain(1, parser));
    }

    @Test
    public void shouldReturnFalseIfNoNeedToGetUserChoiceAgainIfQuitting() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        Library library = mock(Library.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = mock(Parser.class);
        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, library, mainMenu);

        when(parser.isQuitting(2)).thenReturn(true);

        assertEquals(true, libraryApplication.shouldGetChoiceAgain(2, parser));
    }

    @Test
    public void shouldAssignAValidDelegateMenuWithTheHelpOfParserAndExecuteIt() {
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = mock(Parser.class);
        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, library, mainMenu);
        ListBooksMenu listBooksMenu = mock(ListBooksMenu.class);

        when(parser.assignADelegateMenu(1)).thenReturn(listBooksMenu);
        libraryApplication.executeMenu(parser, 1);

        verify(parser, times(1)).assignADelegateMenu(1);
        verify(listBooksMenu, times(1)).execute();
    }

    @Test
    public void shouldGetChoiceAndAskForExecution() {
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = mock(Parser.class);
        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, library, mainMenu);
        ListBooksMenu listBooksMenu = mock(ListBooksMenu.class);

        when(userInterface.getMenuChoice()).thenReturn(1);
        when(parser.assignADelegateMenu(1)).thenReturn(listBooksMenu);

        assertEquals(1, libraryApplication.getChoiceAndExecute(parser));
    }
}
