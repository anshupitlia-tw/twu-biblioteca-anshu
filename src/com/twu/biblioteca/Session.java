package com.twu.biblioteca;

public class Session {
    private Guest currentUser;

    public Session(Guest currentUser) {
        this.currentUser = currentUser;
    }

    public Guest getCurrentUser() {
        return currentUser;
    }


    public void putCurrentUser(Guest currentUser) {
        this.currentUser = currentUser;
    }
}
