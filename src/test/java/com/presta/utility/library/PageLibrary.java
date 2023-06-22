package com.presta.utility.library;

import com.presta.pages.ui.LoginFunctionalityPage;
import com.presta.pages.ui.UserRegistrationPage;

public class PageLibrary {
    private LoginFunctionalityPage loginFunctionalityPage;
    private UserRegistrationPage userRegistrationPage;

    public PageLibrary() {
        loginFunctionalityPage= new LoginFunctionalityPage();
        userRegistrationPage= new UserRegistrationPage();
    }

    public LoginFunctionalityPage getLoginFunctionalityPage() {
        return loginFunctionalityPage;
    }

    public UserRegistrationPage getUserRegistrationPage() {
        return userRegistrationPage;
    }
}
