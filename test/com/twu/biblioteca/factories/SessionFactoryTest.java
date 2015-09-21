package com.twu.biblioteca.factories;

import com.twu.biblioteca.authentication.Guest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SessionFactoryTest {

    @Test
    public void shouldInitiallyCreateSessionWithAGuestUser() {
        SessionFactory sessionFactory = new SessionFactory();

        assertEquals(Guest.class, sessionFactory.createGuestSession().getCurrentUser().getClass());
    }
}
