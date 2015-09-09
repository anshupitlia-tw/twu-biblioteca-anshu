package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map.Entry;

public class MainMenu {
    private HashMap<Integer, MenuItem> menuItems;

    MainMenu(HashMap<Integer, MenuItem> mainMenu) {
        this.menuItems = mainMenu;
    }

    public String getListOfMenuForDisplay() {
        String listOfMenus = "";
        for (Entry<Integer, MenuItem> menu: menuItems.entrySet()) {
            listOfMenus += menu.getKey()+ ". ";
            listOfMenus += menu.getValue().getName() +"\n";
        }
        return listOfMenus;
    }

    public MenuItem getMenu(int menuNumber ) {
        return menuItems.get(menuNumber);
    }

    public boolean hasMenu(int choice) {
        return menuItems.containsKey(choice);
    }
}
