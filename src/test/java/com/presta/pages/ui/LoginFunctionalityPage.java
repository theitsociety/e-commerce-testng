package com.presta.pages.ui;

import com.presta.elements.ui.LoginFunctionalityElement;
import com.presta.utility.ConfigReader;
import com.presta.utility.Utility;

public class LoginFunctionalityPage extends Utility {
    /**
     * Given User is on the homepage
     * When user clicks on Sing In link
     * Then User will forward to Login Page
     * And User enters the email and password
     *  |testuser@gmail.com|test1234|
     * And user clicks sing in button
     * Then user should be able to see the "My account - My Store" title
     * Then user should be able to verify the "Welcome to your account. Here you can manage all of your personal information and orders."
     */
    LoginFunctionalityElement loginFunctionalityElement =new LoginFunctionalityElement();
    public void loginFunctionalityTest(){


    }

}
