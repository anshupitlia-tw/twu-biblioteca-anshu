
package com.twu.biblioteca.factories;

import com.twu.biblioteca.authentication.Session;
import com.twu.biblioteca.authentication.Users;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class GuestUserMainMenuFactoryTest {

    @Test
    public void shouldHaveAMenuForListingBooks() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu = new GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);

        assertEquals(com.twu.biblioteca.menu_items.ListBooksMenuItem.class, mainMenu.getMenu("1").getClass());
    }

    @Test
    public void shouldHaveAMenuForQuitting() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu = new GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);

        assertEquals(com.twu.biblioteca.menu_items.QuitMenuItem.class, mainMenu.getMenu("2").getClass());
    }

    @Test
    public void shouldHaveAMenuForCheckingOutABook() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu = new GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);

        assertEquals(com.twu.biblioteca.menu_items.CheckoutBookMenuItem.class, mainMenu.getMenu("3").getClass());
    }

    @Test
    public void shouldHaveAMenuForReturningABook() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu = new GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);

        assertEquals(com.twu.biblioteca.menu_items.ReturnBookMenuItem.class, mainMenu.getMenu("4").getClass());
    }

    @Test
    public void shouldHaveAMenuForListingMovies() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu = new GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);

        assertEquals(com.twu.biblioteca.menu_items.ListMoviesMenuItem.class, mainMenu.getMenu("5").getClass());
    }

    @Test
    public void shouldHaveAMenuForCheckingOutAMovie() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu = new GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);

        assertEquals(com.twu.biblioteca.menu_items.CheckoutMovieMenuItem.class, mainMenu.getMenu("6").getClass());
    }

    @Test
    public void shouldHaveAMenuForLoggingIn() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu = new GuestUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);

        assertEquals(com.twu.biblioteca.menu_items.LoginMenuItem.class, mainMenu.getMenu("7").getClass());
    }
}


