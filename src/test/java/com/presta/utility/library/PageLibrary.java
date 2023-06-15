package com.presta.utility.library;

import com.presta.pages.ui.LoginFunctionalityPage;

public class PageLibrary {
    private LoginFunctionalityPage loginFunctionalityPage;

    public PageLibrary() {
        loginFunctionalityPage= new LoginFunctionalityPage();
    }

    public LoginFunctionalityPage getLoginFunctionalityPage() {
        return loginFunctionalityPage;
    }
}
