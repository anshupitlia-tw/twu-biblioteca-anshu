package com.twu.biblioteca.factories;

import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserIntefaceFactoryTest {

    @Test
    public void shouldCreateUserInterface() {
        UserInterfaceFactory userInterfaceFactory = new UserInterfaceFactory();

        assertEquals(UserInterface.class, userInterfaceFactory.establishUserInterface().getClass());
    }
}
