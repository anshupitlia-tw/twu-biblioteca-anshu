package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map.Entry;

public class MainMenu {
    private HashMap<Integer, String> mainMenu;

    MainMenu(HashMap<Integer, String> mainMenu) {
        this.mainMenu = mainMenu;
    }

    public String getListOfMenuForDisplay() {
        String listOfMenus = "";
        for (Entry<Integer, String> menu: mainMenu.entrySet()) {
            listOfMenus += menu.getKey()+ ". ";
            listOfMenus += menu.getValue();
        }
        return listOfMenus;
    }

    public String getMenu(int menuNumber ) {
        return mainMenu.get(menuNumber);
    }

    public boolean hasMenu(int choice) {
        return mainMenu.containsKey(choice);
    }
}
