package com.twu.biblioteca;

public class UserCredentials {
    private String libraryNumber;
    private String password;

    UserCredentials(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public boolean equals(Object object) {
        UserCredentials accessorUserCredentials = (UserCredentials) object;
        if (this.password.equals(accessorUserCredentials.password) && this.libraryNumber.equals(accessorUserCredentials.libraryNumber))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = libraryNumber.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    public String getLibraryNumberForDisplay() {
        return libraryNumber;
    }
}
