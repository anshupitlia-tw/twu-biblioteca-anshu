package com.twu.biblioteca;

public class SessionFactory {
    private Session session;

    public Session createGuestSession() {
        session = new Session(new Guest());
        return session;
    }
}
