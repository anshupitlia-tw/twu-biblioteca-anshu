package com.twu.biblioteca.factories;

import com.twu.biblioteca.authentication.Guest;
import com.twu.biblioteca.authentication.Session;

public class SessionFactory {
    private Session session;

    public Session createGuestSession() {
        session = new Session(new Guest());
        return session;
    }
}
