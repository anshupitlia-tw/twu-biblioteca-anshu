
package com.twu.biblioteca.controller;

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
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = mock(com.twu.biblioteca.main_menu.MainMenu.class);
        com.twu.biblioteca.parser.Parser parser = mock(com.twu.biblioteca.parser.Parser.class);
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);

        when(messages.getUXMessage("welcome_message")).thenReturn("Welcome! Biblioteca at your service");

        com.twu.biblioteca.controller.LibraryApplication libraryApplication = new com.twu.biblioteca.controller.LibraryApplication(userInterface, messages, mainMenu, parser, session, library, users);
        libraryApplication.start();

        verify(userInterface, times(1)).printOnOutputStream("Welcome! Biblioteca at your service");
    }

    @Test
    public void shouldDisplayTheMainMenuList() {
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = mock(com.twu.biblioteca.main_menu.MainMenu.class);
        com.twu.biblioteca.parser.Parser parser = mock(com.twu.biblioteca.parser.Parser.class);
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);

        com.twu.biblioteca.controller.LibraryApplication libraryApplication = new com.twu.biblioteca.controller.LibraryApplication(userInterface, messages, mainMenu, parser, session, library, users);
        when(mainMenu.getListOfMenuForDisplay()).thenReturn("1. List Books");

        libraryApplication.listMainMenu();

        verify(userInterface, times(1)).printOnOutputStream(mainMenu.getListOfMenuForDisplay());
    }

    @Test
    public void shouldAssignAValidDelegateMenuWithTheHelpOfParserAndExecuteIt() {
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = mock(com.twu.biblioteca.main_menu.MainMenu.class);
        com.twu.biblioteca.parser.Parser parser = mock(com.twu.biblioteca.parser.Parser.class);
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);

        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);

        com.twu.biblioteca.controller.LibraryApplication libraryApplication = new com.twu.biblioteca.controller.LibraryApplication(userInterface, messages, mainMenu, parser, session, library, users);
        com.twu.biblioteca.menu_items.ListBooksMenuItem listBooksMenu = mock(com.twu.biblioteca.menu_items.ListBooksMenuItem.class);
        when(parser.assignADelegateMenu("1")).thenReturn(listBooksMenu);
        libraryApplication.executeMenu("1");

        verify(parser, times(1)).assignADelegateMenu("1");
        verify(listBooksMenu, times(1)).execute();
    }

    @Test
    public void shouldGetChoiceAndAskForExecution() {
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = mock(com.twu.biblioteca.main_menu.MainMenu.class);
        com.twu.biblioteca.parser.Parser parser = mock(com.twu.biblioteca.parser.Parser.class);
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);

        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);

        com.twu.biblioteca.controller.LibraryApplication libraryApplication = new com.twu.biblioteca.controller.LibraryApplication(userInterface, messages, mainMenu, parser, session, library, users);
        com.twu.biblioteca.menu_items.ListBooksMenuItem listBooksMenu = mock(com.twu.biblioteca.menu_items.ListBooksMenuItem.class);

        when(userInterface.getChoiceFromUser()).thenReturn("1");
        when(parser.assignADelegateMenu("1")).thenReturn(listBooksMenu);

        assertEquals("1", libraryApplication.getUserChoice());
    }
}

