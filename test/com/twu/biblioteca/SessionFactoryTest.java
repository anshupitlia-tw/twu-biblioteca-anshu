package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SessionFactoryTest {

    @Test
    public void shouldInitiallyCreateSessionWithANullUser() {
        SessionFactory sessionFactory = new SessionFactory();

        assertEquals(null, sessionFactory.createNullSession().getCurrentUser());
    }
}
