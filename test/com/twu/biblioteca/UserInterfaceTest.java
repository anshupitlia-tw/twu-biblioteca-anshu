package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UserInterfaceTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutContent() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpOutContent() {
        System.setOut(System.out);
    }

    @Test
    public void shouldBeAbleToPrintAMessageGivenToIt() {
        UserInterface ui = new UserInterface();
        ui.print("Welcome!");

        assertEquals("Welcome!\n", outContent.toString());
    }
}
