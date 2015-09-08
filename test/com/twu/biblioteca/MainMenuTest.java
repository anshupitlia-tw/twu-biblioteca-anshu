package com.twu.biblioteca;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    @Test
    public void shouldDisplayListOfMenusNoMatterHowManyMenusAreThere() {
        HashMap<Integer, String> mainMenuList = new HashMap<>();
        mainMenuList.put(1, "List Books");
        MainMenu mainMenu = new MainMenu(mainMenuList);
        String mainMenuToBeDisplayed = "1. List Books\n";

        assertEquals(mainMenuToBeDisplayed, mainMenu.getListOfMenuForDisplay());
    }

    @Test
    public void shouldReturnMenuFromMenuNumber() {
        HashMap<Integer, String> mainMenuList = new HashMap<>();
        mainMenuList.put(1, "List Books");
        MainMenu mainMenu = new MainMenu(mainMenuList);
        String menu = "List Books";

        assertEquals(menu, mainMenu.getMenu(1));
    }

    @Test
    public void shouldReturnTrueIfTheMenuNumberIsValid() {
        HashMap<Integer, String> mainMenuList = new HashMap<>();
        mainMenuList.put(1, "List Books");
        MainMenu mainMenu = new MainMenu(mainMenuList);

        assertEquals(true, mainMenu.hasMenu(1));
    }

    @Test
    public void shouldReturnFalseIfTheMenuNumberIsNotValid() {
        HashMap<Integer, String> mainMenuList = new HashMap<>();
        mainMenuList.put(1, "List Books");
        MainMenu mainMenu = new MainMenu(mainMenuList);

        assertEquals(false, mainMenu.hasMenu(2));
    }
}
