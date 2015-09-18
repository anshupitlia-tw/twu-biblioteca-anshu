
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
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = mock(Parser.class);
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Users users = mock(Users.class);

        when(messages.getUXMessage("welcome_message")).thenReturn("Welcome! Biblioteca at your service");

        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, mainMenu, parser, session, library, users);
        libraryApplication.start();

        verify(userInterface, times(1)).printOnOutputStream("Welcome! Biblioteca at your service");
    }

    @Test
    public void shouldDisplayTheMainMenuList() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = mock(Parser.class);
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Users users = mock(Users.class);

        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, mainMenu, parser, session, library, users);
        when(mainMenu.getListOfMenuForDisplay()).thenReturn("1. List Books");

        libraryApplication.listMainMenu();

        verify(userInterface, times(1)).printOnOutputStream(mainMenu.getListOfMenuForDisplay());
    }

    @Test
    public void shouldAssignAValidDelegateMenuWithTheHelpOfParserAndExecuteIt() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = mock(Parser.class);
        Session session = mock(Session.class);

        Library library = mock(Library.class);
        Users users = mock(Users.class);

        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, mainMenu, parser, session, library, users);
        ListBooksMenuItem listBooksMenu = mock(ListBooksMenuItem.class);
        when(parser.assignADelegateMenu("1")).thenReturn(listBooksMenu);
        libraryApplication.executeMenu("1");

        verify(parser, times(1)).assignADelegateMenu("1");
        verify(listBooksMenu, times(1)).execute();
    }

    @Test
    public void shouldGetChoiceAndAskForExecution() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = mock(Parser.class);
        Session session = mock(Session.class);

        Library library = mock(Library.class);
        Users users = mock(Users.class);

        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, mainMenu, parser, session, library, users);
        ListBooksMenuItem listBooksMenu = mock(ListBooksMenuItem.class);

        when(userInterface.getChoiceFromUser()).thenReturn("1");
        when(parser.assignADelegateMenu("1")).thenReturn(listBooksMenu);

        assertEquals("1", libraryApplication.getUserChoice());
    }
}

