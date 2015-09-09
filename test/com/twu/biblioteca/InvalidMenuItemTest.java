package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class InvalidMenuItemTest {

    @Test
    public void shouldPrintTheMessageToSelectAValidOptionOnTheUserInterfaceWhenItIsExecuting() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        InvalidMenuItem invalidMenu = new InvalidMenuItem(userInterface, messages);
        when(messages.getUXMessage("select_a_valid_option")).thenReturn("Select a valid option!");

        invalidMenu.execute();
        verify(userInterface, times(1)).print("Select a valid option!");
    }
}
