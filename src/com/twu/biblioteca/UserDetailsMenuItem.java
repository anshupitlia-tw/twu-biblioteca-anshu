package com.twu.biblioteca;

public class UserDetailsMenuItem extends  MenuItem{
    private User user;
    private UserInterface userInterface;
    private LoginCaller loginCaller;

    public UserDetailsMenuItem(Session session, UserInterface userInterface, LoginCaller loginCaller) {
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