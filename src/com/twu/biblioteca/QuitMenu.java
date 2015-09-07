package com.twu.biblioteca;

public class QuitMenu implements AMenu {

    @Override
    public void execute() {
        System.exit(0);
    }
}
