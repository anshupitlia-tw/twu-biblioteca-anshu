package com.twu.biblioteca;

import org.junit.Test;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MessagesTest {

    @Test
    public void shouldGiveCorrectUXMessage() {
        HashMap<String, String> testMessages = new HashMap<>();
        testMessages.put("welcome_message", "Welcome! Biblioteca at your service");
        Messages messages = new Messages(testMessages);

        assertEquals("Welcome! Biblioteca at your service", messages.getUXMessage("welcome_message"));
    }
}
