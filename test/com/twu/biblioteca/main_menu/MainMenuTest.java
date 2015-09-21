package com.twu.biblioteca.main_menu;

import com.twu.biblioteca.menu_items.ListBooksMenuItem;
import com.twu.biblioteca.menu_items.MenuItem;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class MainMenuTest {

    @Test
    public void shouldDisplayListOfMenusNoMatterHowManyMenusAreThere() {
        LinkedHashMap<String, MenuItem> mainMenuList = new LinkedHashMap<>();
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);
        mainMenuList.put("1", new ListBooksMenuItem("List Books", userInterface, library));
        MainMenu mainMenu = new MainMenu(mainMenuList);
        String mainMenuToBeDisplayed = "1. List Books\n";

        assertEquals(mainMenuToBeDisplayed, mainMenu.getListOfMenuForDisplay());
    }

    @Test
    public void shouldReturnMenuNameFromMenuNumber() {
        LinkedHashMap<String, MenuItem> mainMenuList = new LinkedHashMap<>();
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);
        mainMenuList.put("1", new ListBooksMenuItem("List Books", userInterface, library));
        MainMenu mainMenu = new MainMenu(mainMenuList);

        String menu = "List Books";

        assertEquals(menu, mainMenu.getMenu("1").getName());
    }

   @Test
    public void shouldReturnTrueIfTheMenuNumberIsValid() {
       LinkedHashMap<String, MenuItem> mainMenuList = new LinkedHashMap<>();
       UserInterface userInterface = mock(UserInterface.class);
       Library library = mock(Library.class);
       mainMenuList.put("1", new ListBooksMenuItem("List Books", userInterface, library));
       MainMenu mainMenu = new MainMenu(mainMenuList);

        assertEquals(true, mainMenu.hasMenu("1"));
    }

    @Test
    public void shouldReturnFalseIfTheMenuNumberIsNotValid() {
        LinkedHashMap<String, MenuItem> mainMenuList = new LinkedHashMap<>();
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);
        mainMenuList.put("1", new ListBooksMenuItem("List Books", userInterface, library));
        MainMenu mainMenu = new MainMenu(mainMenuList);

        assertEquals(false, mainMenu.hasMenu("2"));
    }
}
