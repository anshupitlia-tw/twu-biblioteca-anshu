package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitMenuTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldQuitTheApplicationOnExecute() {
        exit.expectSystemExitWithStatus(0);
        QuitMenu quitMenu =  new QuitMenu("Quit");
        quitMenu.execute();
    }
}
