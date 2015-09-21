
package com.twu.biblioteca.user_interface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserInterfaceTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setOutAndErrContent() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpOutContent() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void shouldBeAbleToPrintAMessageGivenToIt() {
        com.twu.biblioteca.user_interface.UserInterface userInterface = new com.twu.biblioteca.user_interface.UserInterface(System.in, System.out, System.err);
        userInterface.printOnOutputStream("Welcome!");

        assertEquals("Welcome!\n", outContent.toString());
    }

    @Test
    public void shouldBeAbleToReadTheBookNameProvidedByUser() {
        String userChoice = "Anna Karenina";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userChoice.getBytes());
        System.setIn(inContent);
        com.twu.biblioteca.user_interface.UserInterface userInterface = new com.twu.biblioteca.user_interface.UserInterface(System.in, System.out, System.err);

        assertEquals("Anna Karenina", userInterface.getChoiceFromUser());
    }

    @Test
    public void shouldBeAbleToReadTheMenuChoiceProvidedByUser() {
        String userChoice = "2";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userChoice.getBytes());
        System.setIn(inContent);
        com.twu.biblioteca.user_interface.UserInterface userInterface = new com.twu.biblioteca.user_interface.UserInterface(System.in, System.out, System.err);

        assertEquals("2", userInterface.getChoiceFromUser());
    }

    @Test
    public void shouldLogErrorToErrorStream() throws IOException {
        com.twu.biblioteca.user_interface.UserInterface userInterface = spy(new com.twu.biblioteca.user_interface.UserInterface(System.in, System.out, System.err));

        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        doReturn(mockBufferedReader).when(userInterface).getBufferedReader();
        when(mockBufferedReader.readLine()).thenThrow(IOException.class);

        String choiceFromUser = userInterface.getChoiceFromUser();

        assertEquals("ERROR in getting input from user", errContent.toString());
    }
}

