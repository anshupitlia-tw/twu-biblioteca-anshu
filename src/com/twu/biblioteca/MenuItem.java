package com.twu.biblioteca;

public abstract class MenuItem {

    protected String name;
    public abstract void execute();

    public String getName() {
        return this.name;
    }
}

