package com.twu.biblioteca.menu_items;

import com.twu.biblioteca.authentication.Session;
import com.twu.biblioteca.authentication.User;
import com.twu.biblioteca.helpers.LoginCaller;
import com.twu.biblioteca.user_interface.UserInterface;

public class UserDetailsMenuItem extends MenuItem {
    private User user;
    private UserInterface userInterface;
    private LoginCaller loginCaller;

    public UserDetailsMenuItem(String name, Session session, UserInterface userInterface, LoginCaller loginCaller) {
        this.name = name;
        this.user = (User)session.getCurrentUser();
        this.userInterface = userInterface;
        this.loginCaller = loginCaller;
    }

    @Override
    public void execute() {
        if (loginCaller.callLoginViewForUser())
            userInterface.printOnOutputStream(user.getUserDetailsInDisplayableFormat());
    }
}
