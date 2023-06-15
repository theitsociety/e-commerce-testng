package com.presta.pages.ui;

import com.presta.elements.ui.LoginFunctionalityElement;
import com.presta.utility.ConfigReader;
import com.presta.utility.Utility;

public class LoginFunctionalityPage extends Utility {
    public String url= ConfigReader.getProperty("url");
    LoginFunctionalityElement loginFunctionalityElement =new LoginFunctionalityElement();
    public void loginFunctionalityTest(){
       // clickElement(loginFunctionalityElement.click);

    }

}
