package com.twu.biblioteca;

public class User extends Guest{
    private UserCredentials userCredentials;
    private String name;
    private String emailAddress;
    private String phoneNumber;

    User(UserCredentials userCredentials, String name, String emailAddress, String phoneNumber) {
        this.userCredentials = userCredentials;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public boolean isValidLogin(UserCredentials accessorCredentials) {
        if (this.userCredentials.equals(accessorCredentials))
            return true;
        else
            return false;
    }

    public String getLibraryNumber() {
        return userCredentials.getLibraryNumberForDisplay();
    }

    public String getUserDetailsInDisplayableFormat() {
        StringBuilder bookDetails = new StringBuilder();
        bookDetails.append(String.format("%-40s%-40s\n%-40s%-40s\n%-40s%-40s\n", "NAME", this.name, "EMAIL ADDRESS", this.emailAddress, "PHONE NUMBER", this.phoneNumber));
        return bookDetails.toString();
    }

    @Override
    public boolean equals(Object that) {
        User thatUser = (User)that;
        return this.getLibraryNumber().equals(thatUser.getLibraryNumber());
    }

    @Override
    public int hashCode() {
        return userCredentials.getLibraryNumberForDisplay().hashCode();
    }

    @Override
    public MainMenu getMainMenu(Session session, Library library, Messages messages, Users users, UserInterface userInterface ) {
        return new LoggedInUserMainMenuFactory().establishMainMenu(session, library, messages, users, userInterface );
    }
}
