package com.twu.biblioteca.menu_items;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitMenuItemTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldQuitTheApplicationOnExecute() {
        exit.expectSystemExitWithStatus(0);
        com.twu.biblioteca.menu_items.QuitMenuItem quitMenu =  new com.twu.biblioteca.menu_items.QuitMenuItem("Quit");
        quitMenu.execute();
    }
}
