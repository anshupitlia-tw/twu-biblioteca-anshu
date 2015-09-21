package com.twu.biblioteca.main_menu;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class MainMenu {
    private LinkedHashMap<String, com.twu.biblioteca.menu_items.MenuItem> menuItems;

    public MainMenu(LinkedHashMap<String, com.twu.biblioteca.menu_items.MenuItem> mainMenu) {
        this.menuItems = mainMenu;
    }

    public String getListOfMenuForDisplay() {
        String listOfMenus = "";
        for (Entry<String, com.twu.biblioteca.menu_items.MenuItem> menu: menuItems.entrySet()) {
            listOfMenus += menu.getKey()+ ". ";
            listOfMenus += menu.getValue().getName() +"\n";
        }
        return listOfMenus;
    }

    public com.twu.biblioteca.menu_items.MenuItem getMenu(String menuNumber ) {
        return menuItems.get(menuNumber);
    }

    public boolean hasMenu(String choice) {
        return menuItems.containsKey(choice);
    }
}
