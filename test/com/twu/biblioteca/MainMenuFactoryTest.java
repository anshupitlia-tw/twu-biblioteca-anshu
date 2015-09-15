package com.twu.biblioteca;

import org.junit.Test;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainMenuFactoryTest {

    @Test
    public void shouldCreateMenuListProperly() {
        LinkedHashMap<String, MenuItem> mainMenuList = new LinkedHashMap<>();
        ListBooksMenuItem listBooksMenuItem = mock(ListBooksMenuItem.class);
        QuitMenuItem quitMenuItem = mock(QuitMenuItem.class);
        CheckoutBookMenuItem checkoutBookMenuItem = mock(CheckoutBookMenuItem.class);
        ReturnBookMenuItem returnBookMenuItem = mock(ReturnBookMenuItem.class);
        ListMoviesMenuItem listMoviesMenuItem = mock(ListMoviesMenuItem.class);
        CheckoutMovieMenuItem checkoutMovieMenuItem = mock(CheckoutMovieMenuItem.class);

        when(listBooksMenuItem.getName()).thenReturn("List Books");
        when(quitMenuItem.getName()).thenReturn("Quit");
        when(checkoutBookMenuItem.getName()).thenReturn("Checkout A Book");
        when(returnBookMenuItem.getName()).thenReturn("Return A Book");
        when(listMoviesMenuItem.getName()).thenReturn("List Movies");
        when(checkoutMovieMenuItem.getName()).thenReturn("Checkout A Movie");

        mainMenuList.put("1", listBooksMenuItem);
        mainMenuList.put("2", quitMenuItem);
        mainMenuList.put("3", checkoutBookMenuItem);
        mainMenuList.put("4", returnBookMenuItem);
        mainMenuList.put("5", listMoviesMenuItem);
        mainMenuList.put("6", checkoutMovieMenuItem);
        MainMenu mainMenu = new MainMenu(mainMenuList);

        assertEquals(mainMenu.getListOfMenuForDisplay(), new MainMenuFactory().establishMainMenu().getListOfMenuForDisplay());
    }

    @Test
    public void shouldHaveAMenuForListingBooks() {
        assertEquals(ListBooksMenuItem.class, new MainMenuFactory().establishMainMenu().getMenu("1").getClass());
    }

    @Test
    public void shouldHaveAMenuForQuitting() {
        assertEquals(QuitMenuItem.class, new MainMenuFactory().establishMainMenu().getMenu("2").getClass());
    }

    @Test
    public void shouldHaveAMenuForCheckingOutABook() {
        assertEquals(CheckoutBookMenuItem.class, new MainMenuFactory().establishMainMenu().getMenu("3").getClass());
    }

    @Test
    public void shouldHaveAMenuForReturningABook() {
        assertEquals(ReturnBookMenuItem.class, new MainMenuFactory().establishMainMenu().getMenu("4").getClass());
    }

    @Test
    public void shouldHaveAMenuForListingMovies() {
       assertEquals(ListMoviesMenuItem.class, new MainMenuFactory().establishMainMenu().getMenu("5").getClass());
    }

    @Test
    public void shouldHaveAMenuForCheckingOutAMovie() {
        assertEquals(CheckoutMovieMenuItem.class, new MainMenuFactory().establishMainMenu().getMenu("6").getClass());
    }
}
