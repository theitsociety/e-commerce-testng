package com.presta.tests.ui.frontend;

import com.presta.tests.testbase.TestBase;
import com.presta.utility.ConfigReader;
import org.testng.annotations.Test;

public class LoginFunctionalityTest extends TestBase {
    public String homePageUrl = ConfigReader.getProperty("url");

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
    @Test(groups = {"smoke"},
    description = "Login functionality testing")
    public void successfulLogin(){
        getAppLibrary().getFlowLibrary().navigateToUrl(homePageUrl);
        getAppLibrary().getPage().getLoginFunctionalityPage().loginFunctionalityTest();
    }

}
