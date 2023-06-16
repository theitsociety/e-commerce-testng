package com.presta.pages.ui;

import com.github.javafaker.Faker;
import com.presta.elements.ui.LoginFunctionalityElement;
import com.presta.utility.ConfigReader;
import com.presta.utility.Utility;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginFunctionalityPage extends Utility {

    SoftAssert sf = new SoftAssert();
    LoginFunctionalityElement loginFunctionalityElement =new LoginFunctionalityElement();

    public void loginFunctionalityTest(){
        String testEmail=ConfigReader.getProperty("testEmail");
        String testPassword=ConfigReader.getProperty("testPassword");
        clickElement(loginFunctionalityElement.signInLink);
        waits(2);
        sendKeyToElement(loginFunctionalityElement.singInEmail,testEmail);
        waits(2);
        sendKeyToElement(loginFunctionalityElement.singInPassword,testPassword);
        waits(2);
        clickElement(loginFunctionalityElement.singInButton);
        waits(2);
        //Actual and Expected result
        String expectedAccountDescription="Welcome to your account. Here you can manage all of your personal information and orders.";
        String actualAccountDescription=getTextElement(loginFunctionalityElement.myAccountDescription);
        Assert.assertEquals(actualAccountDescription,expectedAccountDescription,"Descriptions are not matching");
       //Soft Assertion
        sf.assertEquals(actualAccountDescription,expectedAccountDescription,"Descriptions are not matching");
        sf.assertAll();
    }

}
