package com.twu.biblioteca;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class MainMenuItemTest {

    @Test
    public void shouldDisplayListOfMenusNoMatterHowManyMenusAreThere() {
        HashMap<Integer, MenuItem> mainMenuList = new HashMap<>();
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);
        mainMenuList.put(1, new ListBooksMenuItem("List Books", userInterface, library));
        MainMenu mainMenu = new MainMenu(mainMenuList);
        String mainMenuToBeDisplayed = "1. List Books\n";

        assertEquals(mainMenuToBeDisplayed, mainMenu.getListOfMenuForDisplay());
    }

    @Test
    public void shouldReturnMenuNameFromMenuNumber() {
        HashMap<Integer, MenuItem> mainMenuList = new HashMap<>();
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);
        mainMenuList.put(1, new ListBooksMenuItem("List Books", userInterface, library));
        MainMenu mainMenu = new MainMenu(mainMenuList);

        String menu = "List Books";

        assertEquals(menu, mainMenu.getMenu(1).getName());
    }

   @Test
    public void shouldReturnTrueIfTheMenuNumberIsValid() {
       HashMap<Integer, MenuItem> mainMenuList = new HashMap<>();
       UserInterface userInterface = mock(UserInterface.class);
       Library library = mock(Library.class);
       mainMenuList.put(1, new ListBooksMenuItem("List Books", userInterface, library));
       MainMenu mainMenu = new MainMenu(mainMenuList);

        assertEquals(true, mainMenu.hasMenu(1));
    }

    @Test
    public void shouldReturnFalseIfTheMenuNumberIsNotValid() {
        HashMap<Integer, MenuItem> mainMenuList = new HashMap<>();
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);
        mainMenuList.put(1, new ListBooksMenuItem("List Books", userInterface, library));
        MainMenu mainMenu = new MainMenu(mainMenuList);

        assertEquals(false, mainMenu.hasMenu(2));
    }
}
