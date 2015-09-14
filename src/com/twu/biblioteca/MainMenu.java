package com.twu.biblioteca;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class MainMenu {
    private LinkedHashMap<String, MenuItem> menuItems;

    MainMenu(LinkedHashMap<String, MenuItem> mainMenu) {
        this.menuItems = mainMenu;
    }

    public String getListOfMenuForDisplay() {
        String listOfMenus = "";
        for (Entry<String, MenuItem> menu: menuItems.entrySet()) {
            listOfMenus += menu.getKey()+ ". ";
            listOfMenus += menu.getValue().getName() +"\n";
        }
        return listOfMenus;
    }

    public MenuItem getMenu(String menuNumber ) {
        return menuItems.get(menuNumber);
    }

    public boolean hasMenu(String choice) {
        return menuItems.containsKey(choice);
    }
}
