package com.twu.biblioteca.factories;

import com.twu.biblioteca.authentication.Guest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SessionFactoryTest {

    @Test
    public void shouldInitiallyCreateSessionWithAGuestUser() {
        com.twu.biblioteca.factories.SessionFactory sessionFactory = new com.twu.biblioteca.factories.SessionFactory();

        assertEquals(Guest.class, sessionFactory.createGuestSession().getCurrentUser().getClass());
    }
}
