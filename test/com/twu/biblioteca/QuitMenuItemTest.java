package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitMenuItemTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldQuitTheApplicationOnExecute() {
        exit.expectSystemExitWithStatus(0);
        QuitMenuItem quitMenu =  new QuitMenuItem("Quit");
        quitMenu.execute();
    }
}
