package com.twu.biblioteca.menu_items;

import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class InvalidMenuItemTest {

    @Test
    public void shouldPrintTheMessageToSelectAValidOptionOnTheUserInterfaceWhenItIsExecuting() {
        UserInterface userInterface = mock(UserInterface.class);
        Messages messages = mock(Messages.class);
        com.twu.biblioteca.menu_items.InvalidMenuItem invalidMenu = new com.twu.biblioteca.menu_items.InvalidMenuItem(userInterface, messages);
        when(messages.getUXMessage("select_a_valid_option")).thenReturn("Select a valid option!");

        invalidMenu.execute();
        verify(userInterface, times(1)).printOnOutputStream("Select a valid option!");
    }
}
