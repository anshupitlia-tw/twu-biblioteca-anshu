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

        when(listBooksMenuItem.getName()).thenReturn("List Books");
        when(quitMenuItem.getName()).thenReturn("Quit");
        when(checkoutBookMenuItem.getName()).thenReturn("Checkout A Book");
        when(returnBookMenuItem.getName()).thenReturn("Return A Book");

        mainMenuList.put("1", listBooksMenuItem);
        mainMenuList.put("2", quitMenuItem);
        mainMenuList.put("3", checkoutBookMenuItem);
        mainMenuList.put("4", returnBookMenuItem);
        MainMenu mainMenu = new MainMenu(mainMenuList);

        assertEquals(mainMenu.getListOfMenuForDisplay(), new MainMenuFactory().establishMainMenu().getListOfMenuForDisplay());
    }


}
