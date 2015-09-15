package com.twu.biblioteca;

public class Session {
    private User currentUser;

    public Session(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void putCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
