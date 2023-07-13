package com.presta.tests.ui.frontend;

import com.presta.tests.testbase.TestBase;
import com.presta.tests.testbase.dataprovider.DataProviderClass;
import com.presta.utility.ConfigReader;
import org.testng.annotations.Test;

public class UserRegistrationTestDataProviderWithExcel extends TestBase {
    String homePageUrl=ConfigReader.getProperty("url");


    @Test(groups = {"smoke"}, description = "Valid user registration testing",
            dataProvider = "getDataFromExcel",
            dataProviderClass = DataProviderClass.class)
    public void registerValidUserWithDataProvider1(Object[] userData){
        String  emailAddress= String.valueOf(userData[0]);
        String  firstName= String.valueOf(userData[1]);
        String lastName= String.valueOf(userData[2]);
        String password= String.valueOf(userData[3]);
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
