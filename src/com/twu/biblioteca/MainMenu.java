package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map.Entry;

public class MainMenu {
    private HashMap<Integer, AMenu> mainMenu;

    MainMenu(HashMap<Integer, AMenu> mainMenu) {
        this.mainMenu = mainMenu;
    }

    public String getListOfMenuForDisplay() {
        String listOfMenus = "";
        for (Entry<Integer, AMenu> menu: mainMenu.entrySet()) {
            listOfMenus += menu.getKey()+ ". ";
            listOfMenus += menu.getValue().getName() +"\n";
        }
        return listOfMenus;
    }

    public AMenu getMenu(int menuNumber ) {
        return mainMenu.get(menuNumber);
    }

    public boolean hasMenu(int choice) {
        return mainMenu.containsKey(choice);
    }
}
