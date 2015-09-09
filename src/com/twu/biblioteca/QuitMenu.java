package com.twu.biblioteca;

public class QuitMenu extends AMenu {

    QuitMenu(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
