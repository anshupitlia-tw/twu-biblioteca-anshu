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

        when(messages.getUXMessage("welcome_message")).thenReturn("Welcome! Biblioteca at your service");

        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, mainMenu, parser);
        libraryApplication.start();

        verify(userInterface, times(1)).print("Welcome! Biblioteca at your service");
    }

    @Test
    public void shouldDisplayTheMainMenuList() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = mock(Parser.class);
        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, mainMenu, parser);
        when(mainMenu.getListOfMenuForDisplay()).thenReturn("1. List Books");

        libraryApplication.listMainMenu();

        verify(userInterface, times(1)).print(mainMenu.getListOfMenuForDisplay());
    }

    @Test
    public void shouldAssignAValidDelegateMenuWithTheHelpOfParserAndExecuteIt() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = mock(Parser.class);
        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, mainMenu, parser);
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
        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, mainMenu, parser);
        ListBooksMenuItem listBooksMenu = mock(ListBooksMenuItem.class);

        when(userInterface.getChoiceFromUser()).thenReturn("1");
        when(parser.assignADelegateMenu("1")).thenReturn(listBooksMenu);

        assertEquals("1", libraryApplication.getUserChoice());
    }

    @Test
    public void shouldProperlyGetUserChoiceUntilQuitOrInvalidChoiceAndExecuteOnValidity() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Parser parser = mock(Parser.class);
        LibraryApplication libraryApplication = new LibraryApplication(userInterface, messages, mainMenu, parser);
        ListBooksMenuItem listBooksMenuItem = mock(ListBooksMenuItem.class);
        QuitMenuItem quitMenuItem = mock(QuitMenuItem.class);
        CheckoutBookMenuItem checkoutBookMenuItem = mock(CheckoutBookMenuItem.class);
        InvalidMenuItem invalidMenuItem = new InvalidMenuItem(userInterface, messages);

        when(mainMenu.getListOfMenuForDisplay()).thenReturn("Some menu");
        when(userInterface.getChoiceFromUser()).thenReturn("1").thenReturn("3").thenReturn("6").thenReturn("2");
        when(parser.assignADelegateMenu("1")).thenReturn(listBooksMenuItem);
        when(parser.assignADelegateMenu("2")).thenReturn(quitMenuItem);
        when(parser.assignADelegateMenu("3")).thenReturn(checkoutBookMenuItem);
        when(parser.assignADelegateMenu("6")).thenReturn(invalidMenuItem);
        when(parser.isNotTheEndOfParsing("1")).thenReturn(true);
        when(parser.isNotTheEndOfParsing("3")).thenReturn(true);
        when(parser.isNotTheEndOfParsing("6")).thenReturn(true);
        when(parser.isNotTheEndOfParsing("2")).thenReturn(false);

        libraryApplication.controlUserChoice();

        verify(parser, times(4)).isNotTheEndOfParsing(anyString());
    }
}
