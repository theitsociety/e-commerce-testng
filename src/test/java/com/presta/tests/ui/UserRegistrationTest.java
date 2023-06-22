package com.presta.tests.ui;

import com.presta.tests.testbase.TestBase;
import com.presta.utility.ConfigReader;
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

    @Test
    public void registerValidUser(){
        getAppLibrary().getFlowLibrary().navigateToUrl(homePageUrl );
        getAppLibrary().getPage().getUserRegistrationPage().createNewUserRegistration();
    }
}
