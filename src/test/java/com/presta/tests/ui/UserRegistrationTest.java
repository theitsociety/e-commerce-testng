package com.presta.tests.ui;

import com.github.javafaker.Faker;
import com.presta.tests.testbase.TestBase;
import com.presta.utility.ConfigReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRegistrationTest extends TestBase {
    /**
     * Enter valid details and check if the user is able to register successfully.
     * 1- Go to the home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
     * 2- click sign in  //a[@class='login']
     * 3- Enter email  //input[@id='email_create']
     * 4- click create account  //span[text()='Create an account']
     * 6- fill the requirements field
     * Title //input[@id='id_gender2']
     * first name //input[@id='customer_firstname']
     * last name //input[@id='customer_lastname']
     * password //input[@id='passwd']
     * date of birth
     * day   //select[@id='days']//option[@value='12']  /
     * month  //select[@id='months']  /
     * year  //select[@id='years']
     * click register
     */
    String homePageUrl=ConfigReader.getProperty("url");
    Faker faker = new Faker();
    String emailAddress= faker.internet().emailAddress();
    String firstName =faker.name().firstName();
    String lastName= faker.name().lastName();
    String password="test1234";

    @Test(groups = {"smoke"},
            description = "Valid user registration testing")
    public void registerValidUser(){
        getAppLibrary().getFlowLibrary().navigateToUrl(homePageUrl );
        getAppLibrary().getPage().getUserRegistrationPage().createNewUserRegistration(emailAddress,firstName,lastName,password);
    }

    @DataProvider(name = "userRegistration")
    public Object[][] newUserData(){
        return new Object[][]{
                {"abcy@gmail.com","John","Doe","test1234"},
                {"xyz@gmail.com","Mary","Jane","test1234"},
                {"ert@gmail.com","Jack","Jakson","test1234"},
                {"opk@gmail.com","Rahul","Shetty","test1234"},
        };
    }
    @Test(groups = {"smoke"}, dataProvider = "userRegistration",
            description = "Valid user registration testing")
    public void registerValidUserWithDataProvider(String emailAddress, String firstName, String lastName, String password){
        getAppLibrary().getFlowLibrary().navigateToUrl(homePageUrl );
        getAppLibrary().getPage().getUserRegistrationPage().createNewUserRegistration(emailAddress,firstName,lastName,password);
    }

    @Test(groups = {"smoke"}, dataProvider = "userRegistration",
            description = "Valid user registration testing")
    public void registerValidUserWithDataProvider1(String[] userData){
        String emailAddress=userData[0];
        String firstName=userData[1];
        String lastName=userData[2];
        String password=userData[3];
        getAppLibrary().getFlowLibrary().navigateToUrl(homePageUrl );
        getAppLibrary().getPage().getUserRegistrationPage().createNewUserRegistration(emailAddress,firstName,lastName,password);
    }

    @Test(groups = {"smoke"}, dataProvider = "userRegistration",
            description = "Valid user registration testing")
    public void registerValidUserWithDataProvider2(String... userData){
        String emailAddress=userData[0];
        String firstName=userData[1];
        String lastName=userData[2];
        String password=userData[3];
        getAppLibrary().getFlowLibrary().navigateToUrl(homePageUrl );
        getAppLibrary().getPage().getUserRegistrationPage().createNewUserRegistration(emailAddress,firstName,lastName,password);
    }


}
