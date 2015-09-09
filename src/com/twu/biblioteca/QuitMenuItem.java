package com.twu.biblioteca;

public class QuitMenuItem extends MenuItem {

    QuitMenuItem(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
