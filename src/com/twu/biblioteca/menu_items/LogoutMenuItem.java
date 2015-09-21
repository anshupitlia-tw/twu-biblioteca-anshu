package com.twu.biblioteca.menu_items;


import com.twu.biblioteca.authentication.Guest;
import com.twu.biblioteca.authentication.Session;

public class LogoutMenuItem extends MenuItem {

    private Session session;

    public LogoutMenuItem(String name, Session session) {
        this.name = name;
        this.session = session;
    }

    @Override
    public void execute() {
        session.putCurrentUser(new Guest());
    }
}
