
package com.twu.biblioteca;

import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuestUserMainMenuFactoryTest {

    @Test
    public void shouldCreateMenuListProperly() {
        LinkedHashMap<String, MenuItem> mainMenuList = new LinkedHashMap<>();
        ListBooksMenuItem listBooksMenuItem = mock(ListBooksMenuItem.class);
        QuitMenuItem quitMenuItem = mock(QuitMenuItem.class);
        CheckoutBookMenuItem checkoutBookMenuItem = mock(CheckoutBookMenuItem.class);
        ReturnBookMenuItem returnBookMenuItem = mock(ReturnBookMenuItem.class);
        ListMoviesMenuItem listMoviesMenuItem = mock(ListMoviesMenuItem.class);
        CheckoutMovieMenuItem checkoutMovieMenuItem = mock(CheckoutMovieMenuItem.class);
        LoginMenuItem loginMenuItem = mock(LoginMenuItem.class);
        Session session = mock(Session.class);

        when(listBooksMenuItem.getName()).thenReturn("List Books");
        when(quitMenuItem.getName()).thenReturn("Quit");
        when(checkoutBookMenuItem.getName()).thenReturn("Checkout A Book");
        when(returnBookMenuItem.getName()).thenReturn("Return A Book");
        when(listMoviesMenuItem.getName()).thenReturn("List Movies");
        when(checkoutMovieMenuItem.getName()).thenReturn("Checkout A Movie");
        when(loginMenuItem.getName()).thenReturn("Login");

        mainMenuList.put("1", listBooksMenuItem);
        mainMenuList.put("2", quitMenuItem);
        mainMenuList.put("3", checkoutBookMenuItem);
        mainMenuList.put("4", returnBookMenuItem);
        mainMenuList.put("5", listMoviesMenuItem);
        mainMenuList.put("6", checkoutMovieMenuItem);
        mainMenuList.put("7", loginMenuItem);
        MainMenu mainMenu = new MainMenu(mainMenuList);

        assertEquals(mainMenu.getListOfMenuForDisplay(), new GuestUserMainMenuFactory().establishMainMenu(session).getListOfMenuForDisplay());
    }

    @Test
    public void shouldHaveAMenuForListingBooks() {
        Session session = mock(Session.class);
        assertEquals(ListBooksMenuItem.class, new GuestUserMainMenuFactory().establishMainMenu(session).getMenu("1").getClass());
    }

    @Test
    public void shouldHaveAMenuForQuitting() {
        Session session = mock(Session.class);
        assertEquals(QuitMenuItem.class, new GuestUserMainMenuFactory().establishMainMenu(session).getMenu("2").getClass());
    }

    @Test
    public void shouldHaveAMenuForCheckingOutABook() {
        Session session = mock(Session.class);
        assertEquals(CheckoutBookMenuItem.class, new GuestUserMainMenuFactory().establishMainMenu(session).getMenu("3").getClass());
    }

    @Test
    public void shouldHaveAMenuForReturningABook() {
        Session session = mock(Session.class);
        assertEquals(ReturnBookMenuItem.class, new GuestUserMainMenuFactory().establishMainMenu(session).getMenu("4").getClass());
    }

    @Test
    public void shouldHaveAMenuForListingMovies() {
        Session session = mock(Session.class);
        assertEquals(ListMoviesMenuItem.class, new GuestUserMainMenuFactory().establishMainMenu(session).getMenu("5").getClass());
    }

    @Test
    public void shouldHaveAMenuForCheckingOutAMovie() {
        Session session = mock(Session.class);
        assertEquals(CheckoutMovieMenuItem.class, new GuestUserMainMenuFactory().establishMainMenu(session).getMenu("6").getClass());
    }
}

