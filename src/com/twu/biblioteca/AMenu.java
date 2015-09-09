package com.twu.biblioteca;

public abstract class AMenu {

    protected String name;
    public abstract void execute();

    public String getName() {
        return this.name;
    }
}

