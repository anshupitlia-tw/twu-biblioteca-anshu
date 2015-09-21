package com.twu.biblioteca.main_menu;

import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class MainMenuTest {

    @Test
    public void shouldDisplayListOfMenusNoMatterHowManyMenusAreThere() {
        LinkedHashMap<String, com.twu.biblioteca.menu_items.MenuItem> mainMenuList = new LinkedHashMap<>();
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        mainMenuList.put("1", new com.twu.biblioteca.menu_items.ListBooksMenuItem("List Books", userInterface, library));
        com.twu.biblioteca.main_menu.MainMenu mainMenu = new com.twu.biblioteca.main_menu.MainMenu(mainMenuList);
        String mainMenuToBeDisplayed = "1. List Books\n";

        assertEquals(mainMenuToBeDisplayed, mainMenu.getListOfMenuForDisplay());
    }

    @Test
    public void shouldReturnMenuNameFromMenuNumber() {
        LinkedHashMap<String, com.twu.biblioteca.menu_items.MenuItem> mainMenuList = new LinkedHashMap<>();
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        mainMenuList.put("1", new com.twu.biblioteca.menu_items.ListBooksMenuItem("List Books", userInterface, library));
        com.twu.biblioteca.main_menu.MainMenu mainMenu = new com.twu.biblioteca.main_menu.MainMenu(mainMenuList);

        String menu = "List Books";

        assertEquals(menu, mainMenu.getMenu("1").getName());
    }

   @Test
    public void shouldReturnTrueIfTheMenuNumberIsValid() {
       LinkedHashMap<String, com.twu.biblioteca.menu_items.MenuItem> mainMenuList = new LinkedHashMap<>();
       com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
       com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
       mainMenuList.put("1", new com.twu.biblioteca.menu_items.ListBooksMenuItem("List Books", userInterface, library));
       com.twu.biblioteca.main_menu.MainMenu mainMenu = new com.twu.biblioteca.main_menu.MainMenu(mainMenuList);

        assertEquals(true, mainMenu.hasMenu("1"));
    }

    @Test
    public void shouldReturnFalseIfTheMenuNumberIsNotValid() {
        LinkedHashMap<String, com.twu.biblioteca.menu_items.MenuItem> mainMenuList = new LinkedHashMap<>();
        com.twu.biblioteca.user_interface.UserInterface userInterface = mock(com.twu.biblioteca.user_interface.UserInterface.class);
        com.twu.biblioteca.models.Library library = mock(com.twu.biblioteca.models.Library.class);
        mainMenuList.put("1", new com.twu.biblioteca.menu_items.ListBooksMenuItem("List Books", userInterface, library));
        com.twu.biblioteca.main_menu.MainMenu mainMenu = new com.twu.biblioteca.main_menu.MainMenu(mainMenuList);

        assertEquals(false, mainMenu.hasMenu("2"));
    }
}
