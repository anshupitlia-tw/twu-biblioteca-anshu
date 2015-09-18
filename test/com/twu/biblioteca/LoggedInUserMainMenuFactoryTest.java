package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class LoggedInUserMainMenuFactoryTest {
    @Test
    public void shouldHaveAMenuForListingBooks() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu =  new LoggedInUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(ListBooksMenuItem.class, mainMenu.getMenu("1").getClass());
    }

    @Test
    public void shouldHaveAMenuForQuitting() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu =  new LoggedInUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(QuitMenuItem.class, mainMenu.getMenu("2").getClass());
    }

    @Test
    public void shouldHaveAMenuForCheckingOutABook() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu =  new LoggedInUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(CheckoutBookMenuItem.class, mainMenu.getMenu("3").getClass());
    }

    @Test
    public void shouldHaveAMenuForReturningABook() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu =  new LoggedInUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(ReturnBookMenuItem.class, mainMenu.getMenu("4").getClass());
    }

    @Test
    public void shouldHaveAMenuForListingMovies() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu =  new LoggedInUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(ListMoviesMenuItem.class, mainMenu.getMenu("5").getClass());
    }

    @Test
    public void shouldHaveAMenuForCheckingOutAMovie() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu =  new LoggedInUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(CheckoutMovieMenuItem.class, mainMenu.getMenu("6").getClass());
    }

    @Test
    public void shouldHaveAMenuForLoggingOut() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu = new LoggedInUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(LogoutMenuItem.class, mainMenu.getMenu("7").getClass());
    }

    @Test
    public void shouldHaveAMenuForViewingDetails() {
        Session session = mock(Session.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);
        MainMenu mainMenu = new LoggedInUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface);
        assertEquals(UserDetailsMenuItem.class, mainMenu.getMenu("8").getClass());
    }
}
