package com.presta.elements.ui.frontend;

import com.presta.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

public class LoginFunctionalityElement {

    public LoginFunctionalityElement() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[@class='info-account']")
    public WebElement myAccountDescription;

    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    public WebElement signInLink;

    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement singInEmail;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    public WebElement singInPassword;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    public WebElement singInButton;

}
