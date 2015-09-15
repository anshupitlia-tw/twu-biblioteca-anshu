package com.twu.biblioteca;

public class SessionFactory {
    private Session session;

    public Session createNullSession() {
        session = new Session(null);
        return session;
    }
}
