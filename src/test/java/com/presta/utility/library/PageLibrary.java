package com.presta.utility.library;

import com.presta.pages.ui.admin.catalogs.products.AddProductsPage;
import com.presta.pages.ui.frontend.LoginFunctionalityPage;
import com.presta.pages.ui.frontend.UserRegistrationPage;

public class PageLibrary {
    private LoginFunctionalityPage loginFunctionalityPage;
    private UserRegistrationPage userRegistrationPage;
    private AddProductsPage addProductsPage;


    public PageLibrary() {
        loginFunctionalityPage = new LoginFunctionalityPage();
        userRegistrationPage = new UserRegistrationPage();
        addProductsPage = new AddProductsPage();
    }

    public LoginFunctionalityPage getLoginFunctionalityPage() {
        return loginFunctionalityPage;
    }

    public UserRegistrationPage getUserRegistrationPage() {
        return userRegistrationPage;
    }

    public AddProductsPage getAddProductsPage() {
        return addProductsPage;
    }
}
