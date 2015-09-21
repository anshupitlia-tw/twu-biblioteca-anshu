
package com.twu.biblioteca.factories;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class GuestUserMainMenuFactoryTest {

    @Test
    public void shouldHaveAMenuForListingBooks() {
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = new com.twu.biblioteca.factories.GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(com.twu.biblioteca.menu_items.ListBooksMenuItem.class, mainMenu.getMenu("1").getClass());
    }

    @Test
    public void shouldHaveAMenuForQuitting() {
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = new com.twu.biblioteca.factories.GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(com.twu.biblioteca.menu_items.QuitMenuItem.class, mainMenu.getMenu("2").getClass());
    }

    @Test
    public void shouldHaveAMenuForCheckingOutABook() {
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = new com.twu.biblioteca.factories.GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(com.twu.biblioteca.menu_items.CheckoutBookMenuItem.class, mainMenu.getMenu("3").getClass());
    }

    @Test
    public void shouldHaveAMenuForReturningABook() {
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = new com.twu.biblioteca.factories.GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(com.twu.biblioteca.menu_items.ReturnBookMenuItem.class, mainMenu.getMenu("4").getClass());
    }

    @Test
    public void shouldHaveAMenuForListingMovies() {
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = new com.twu.biblioteca.factories.GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(com.twu.biblioteca.menu_items.ListMoviesMenuItem.class, mainMenu.getMenu("5").getClass());
    }

    @Test
    public void shouldHaveAMenuForCheckingOutAMovie() {
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = new com.twu.biblioteca.factories.GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(com.twu.biblioteca.menu_items.CheckoutMovieMenuItem.class, mainMenu.getMenu("6").getClass());
    }

    @Test
    public void shouldHaveAMenuForLoggingIn() {
        com.twu.biblioteca.authentication.Session session = mock(com.twu.biblioteca.authentication.Session.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        com.twu.biblioteca.helpers.Messages messages = mock(com.twu.biblioteca.helpers.Messages.class);
        com.twu.biblioteca.authentication.Users users = mock(com.twu.biblioteca.authentication.Users.class);
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.main_menu.MainMenu mainMenu = new com.twu.biblioteca.factories.GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(com.twu.biblioteca.menu_items.LoginMenuItem.class, mainMenu.getMenu("7").getClass());
    }
}


