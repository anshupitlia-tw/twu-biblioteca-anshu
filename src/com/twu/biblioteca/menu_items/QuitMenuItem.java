package com.twu.biblioteca.menu_items;

public class QuitMenuItem extends MenuItem {

    public QuitMenuItem(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
