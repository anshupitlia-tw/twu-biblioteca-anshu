
package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
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
        UserInterface userInterface = new UserInterface(System.in, System.out);
        userInterface.print("Welcome!");

        assertEquals("Welcome!\n", outContent.toString());
    }

    @Test
    public void shouldBeAbleToReadTheBookNameProvidedByUser() {
        String userChoice = "Anna Karenina";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userChoice.getBytes());
        System.setIn(inContent);
        UserInterface userInterface = new UserInterface(System.in, System.out);

        assertEquals("Anna Karenina", userInterface.getChoiceFromUser());
    }

    @Test
    public void shouldBeAbleToReadTheMenuChoiceProvidedByUser() {
        String userChoice = "2";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userChoice.getBytes());
        System.setIn(inContent);
        UserInterface userInterface = new UserInterface(System.in, System.out);

        assertEquals("2", userInterface.getChoiceFromUser());
    }
}

