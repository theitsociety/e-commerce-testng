package com.presta.elements.ui.admin.catalogs.products;

import com.presta.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductsElement {
    public AddProductsElement() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement password;

    @FindBy(xpath = "//span[@class='ladda-label']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[normalize-space()='Catalog']")
    public WebElement catalogLink;

    @FindBy(xpath = "//li[@id='subtab-AdminProducts']")
    public WebElement addProductLink;

    @FindBy(xpath = "//div[normalize-space()='Add new product']")
    public WebElement addProductButton;

    @FindBy(xpath = "//input[@id='name_1']")
    public WebElement productName;

    @FindBy(xpath = "//div[@id='product-informations']//button[@name='submitAddproductAndStay'][normalize-space()='Save and stay']//i[@class='process-icon-save']")
    public WebElement saveAndStayButton;

    @FindBy(xpath = "//a[@id='link-Images']")
    public WebElement imagesButton;

    @FindBy(xpath = "//button[@id='file-add-button']")
    public WebElement addFilesButton;

    @FindBy(xpath = "//span[normalize-space()='Upload files']")
    public WebElement uploadFilesButton;

    @FindBy(xpath = "//div[@id='product-images']//button[@name='submitAddproduct'][normalize-space()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//body//div[@id='main']//div[@id='product-tab-content-Images']//div[@class='row']//div[@class='row']//span[1]")
    public WebElement verifyUpload;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successfulUpload;
}
