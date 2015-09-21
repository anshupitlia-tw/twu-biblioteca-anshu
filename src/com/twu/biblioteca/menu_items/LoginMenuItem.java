package com.twu.biblioteca.menu_items;

public class LoginMenuItem extends MenuItem {
    private com.twu.biblioteca.user_interface.UserInterface userInterface;
    private com.twu.biblioteca.authentication.Users users;
    private com.twu.biblioteca.authentication.Session session;
    private com.twu.biblioteca.helpers.Messages messages;

    public LoginMenuItem(String name, com.twu.biblioteca.user_interface.UserInterface userInterface, com.twu.biblioteca.authentication.Users users, com.twu.biblioteca.authentication.Session session, com.twu.biblioteca.helpers.Messages messages) {
        this.name = name;
        this.userInterface = userInterface;
        this.users = users;
        this.session = session;
        this.messages = messages;
    }

    @Override
    public void execute() {
        userInterface.printOnOutputStream(messages.getUXMessage("enter_library_number"));
        String libraryNumber = userInterface.getChoiceFromUser();
        userInterface.printOnOutputStream(messages.getUXMessage("enter_password"));
        String password = userInterface.getChoiceFromUser();
        com.twu.biblioteca.authentication.UserCredentials accessorUserCredentials = new com.twu.biblioteca.authentication.UserCredentials(libraryNumber, password);
        com.twu.biblioteca.authentication.Guest currentUser = users.login(accessorUserCredentials);
        if (!(currentUser instanceof com.twu.biblioteca.authentication.User))
            userInterface.printOnOutputStream("Invalid Credentials");
        session.putCurrentUser(currentUser);
    }
}
