package com.twu.biblioteca.menu_items;

public abstract class MenuItem {

    protected String name;
    public abstract void execute();

    public String getName() {
        return this.name;
    }
}

