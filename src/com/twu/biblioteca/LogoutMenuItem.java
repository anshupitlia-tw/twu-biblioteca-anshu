package com.twu.biblioteca;


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
