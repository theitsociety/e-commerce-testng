package com.presta.tests.ui;

import com.presta.tests.testbase.TestBase;
import org.testng.annotations.Test;

public class LoginFunctionalityTest extends TestBase {

    @Test(groups = {"smoke"})
    public void successfulLogin(){
        getAppLibrary().getPage().getLoginFunctionalityPage().loginFunctionalityTest();
        getAppLibrary().getFlowLibrary().getCurrentPageTitle();
        getAppLibrary().getFlowLibrary().getCurrentPageUrl();
    }
}
