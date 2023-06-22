package com.presta.elements.ui;

import com.presta.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegistrationElement {
    public UserRegistrationElement(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**


     * month  //select[@id='months']  /
     * year  //select[@id='years']
     * click register
     */
    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInLink;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement emailRegister;

    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    public WebElement createAnAccount;

    @FindBy(xpath = "//input[@id='id_gender2']")
    public WebElement genderMrs;

    @FindBy(xpath = "//input[@id='id_gender2']")
    public WebElement genderMr;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement registrationPassword;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement registrationDay;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement registrationMonth;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement registrationYear;

    @FindBy(xpath = "//span[normalize-space()='Register']")
    public WebElement clickRegister;

    @FindBy(id = "my-account")
    public WebElement verifyAccountCreation;



}
