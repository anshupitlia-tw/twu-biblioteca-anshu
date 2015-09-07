package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
        UserInterface userInterface = new UserInterface();
        userInterface.print("Welcome!");

        assertEquals("Welcome!\n", outContent.toString());
    }

    @Test
    public void shouldBeAbleToGetUserChoiceOfMenuWhenUserEntersAValidNumber() {
        UserInterface userInterface = new UserInterface();
        String userChoice = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userChoice.getBytes());
        System.setIn(inContent);

        assertEquals(1, userInterface.getMenuChoice());
    }

    @Test
    public void shouldBeAbleToCatchAnExceptionAndPrintAMessageWhenUserEntersNotANumberForMenu() {
        UserInterface userInterface = new UserInterface();
        String userChoice = "abc";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userChoice.getBytes());
        System.setIn(inContent);
        userInterface.getMenuChoice();
        assertEquals("NOT AN INTEGER\n", outContent.toString());
    }

    @Test
    public void shouldBeAbleToReadTheBookNameProvidedByUser() {
        UserInterface userInterface = new UserInterface();
        String userChoice = "Anna Karenina";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userChoice.getBytes());
        System.setIn(inContent);

        assertEquals("Anna Karenina", userInterface.getBookName());
    }
}
