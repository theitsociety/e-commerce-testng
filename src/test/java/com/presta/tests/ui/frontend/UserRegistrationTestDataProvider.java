package com.presta.tests.ui.frontend;

import com.github.javafaker.Faker;
import com.presta.tests.testbase.TestBase;
import com.presta.tests.testbase.dataprovider.DataProviderClass;
import com.presta.utility.ConfigReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRegistrationTestDataProvider extends TestBase {
    String homePageUrl=ConfigReader.getProperty("url");

    @Test(groups = {"smoke"}, description = "Valid user registration testing",
            dataProvider = "newUserData",
            dataProviderClass = DataProviderClass.class)
    public void registerValidUserWithDataProvider(String emailAddress, String firstName, String lastName, String password){
        getAppLibrary().getFlowLibrary().navigateToUrl(homePageUrl );
        getAppLibrary().getPage().getUserRegistrationPage().createNewUserRegistration(emailAddress,firstName,lastName,password);
    }

    @Test(groups = {"smoke"}, description = "Valid user registration testing",
            dataProvider = "oldUserData",
            dataProviderClass = DataProviderClass.class)
    public void registerValidUserWithDataProvider1(String[] userData){
        String emailAddress=userData[0];
        String firstName=userData[1];
        String lastName=userData[2];
        String password=userData[3];
        getAppLibrary().getFlowLibrary().navigateToUrl(homePageUrl );
        getAppLibrary().getPage().getUserRegistrationPage().createNewUserRegistration(emailAddress,firstName,lastName,password);
    }

    @Test(groups = {"smoke"}, description = "Valid user registration testing",
            dataProvider = "dataWithFaker",
            dataProviderClass = DataProviderClass.class)
    public void registerValidUserWithDataProvider2(String... userData){
        String emailAddress=userData[0];
        String firstName=userData[1];
        String lastName=userData[2];
        String password=userData[3];
        getAppLibrary().getFlowLibrary().navigateToUrl(homePageUrl );
        getAppLibrary().getPage().getUserRegistrationPage().createNewUserRegistration(emailAddress,firstName,lastName,password);
    }


}
