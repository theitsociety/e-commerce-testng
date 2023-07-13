package com.presta.pages.ui.frontend;

import com.presta.elements.ui.frontend.UserRegistrationElement;
import com.presta.utility.Driver;
import com.presta.utility.Utility;
import org.testng.Assert;

public class UserRegistrationPage extends Utility {
    UserRegistrationElement userRegistrationElement = new UserRegistrationElement();

    public void createNewUserRegistration(String emailAddress, String firstName, String lastName, String password) {
        clickElement(userRegistrationElement.signInLink);
        waits(2);
        sendKeyToElement(userRegistrationElement.emailRegister,emailAddress);
        clickElement(userRegistrationElement.createAnAccount);
        waits(3);
        clickElement(userRegistrationElement.genderMr);
        sendKeyToElement(userRegistrationElement.firstName,firstName);
        sendKeyToElement(userRegistrationElement.lastName,lastName);
        sendKeyToElement(userRegistrationElement.registrationPassword,password);
        waits(1);
        selectElementByValue(userRegistrationElement.registrationDay, "10");
        waits(1);
        selectElementByIndex(userRegistrationElement.registrationMonth,8);
        waits(1);
        selectElementByValue(userRegistrationElement.registrationYear, "2000");
        waits(1);
        clickElement(userRegistrationElement.clickRegister);
        waits(2);
       /* String expectedResult="Your account has been created.";
        String actualResult=userRegistrationElement.verifyAccountCreation.getText();
        Assert.assertEquals(actualResult.trim(),expectedResult,"Assertion failed");*/

        String expectedResultTitle="My account - My Store";
        String actualResultTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualResultTitle.trim(),expectedResultTitle,"Assertion failed");
    }

}
