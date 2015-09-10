
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
    public void shouldBeAbleToGetUserChoiceOfMenuWhenUserEntersAValidNumber() {
        String userChoice = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userChoice.getBytes());
        System.setIn(inContent);

        UserInterface userInterface = new UserInterface(System.in, System.out);

        assertEquals(1, userInterface.getANumberFromUser());
    }

    @Test
    public void shouldBeAbleToCatchAnExceptionAndPrintAMessageWhenUserEntersNotANumberForMenu() {
        String userChoice = "abc";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userChoice.getBytes());
        System.setIn(inContent);
        UserInterface userInterface = new UserInterface(System.in, System.out);
        userInterface.getANumberFromUser();
        assertEquals("NOT AN INTEGER\n", outContent.toString());
    }

    @Test
    public void shouldBeAbleToReadTheBookNameProvidedByUser() {
        String userChoice = "Anna Karenina";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userChoice.getBytes());
        System.setIn(inContent);
        UserInterface userInterface = new UserInterface(System.in, System.out);

        assertEquals("Anna Karenina", userInterface.getAStringFromUser());
    }
}

