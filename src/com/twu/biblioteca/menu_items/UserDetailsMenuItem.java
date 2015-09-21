package com.twu.biblioteca.menu_items;

public class UserDetailsMenuItem extends MenuItem {
    private com.twu.biblioteca.authentication.User user;
    private com.twu.biblioteca.user_interface.UserInterface userInterface;
    private com.twu.biblioteca.helpers.LoginCaller loginCaller;

    public UserDetailsMenuItem(String name, com.twu.biblioteca.authentication.Session session, com.twu.biblioteca.user_interface.UserInterface userInterface, com.twu.biblioteca.helpers.LoginCaller loginCaller) {
        this.name = name;
        this.user = (com.twu.biblioteca.authentication.User)session.getCurrentUser();
        this.userInterface = userInterface;
        this.loginCaller = loginCaller;
    }

    @Override
    public void execute() {
        if (loginCaller.callLoginViewForUser())
            userInterface.printOnOutputStream(user.getUserDetailsInDisplayableFormat());
    }
}
