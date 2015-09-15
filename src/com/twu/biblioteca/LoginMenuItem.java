package com.twu.biblioteca;

public class LoginMenuItem extends MenuItem {
    private UserInterface userInterface;
    private Users users;
    private Session session;
    private Messages messages;

    LoginMenuItem(String name, UserInterface userInterface, Users users, Session session, Messages messages) {
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
        UserCredentials accessorUserCredentials = new UserCredentials(libraryNumber, password);
        User currentUser = users.login(accessorUserCredentials);
        session.putCurrentUser(currentUser);
    }
}
