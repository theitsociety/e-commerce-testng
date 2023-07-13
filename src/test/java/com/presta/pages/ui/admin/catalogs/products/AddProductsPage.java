package com.presta.pages.ui.admin.catalogs.products;

import com.github.javafaker.Faker;
import com.presta.elements.ui.admin.catalogs.products.AddProductsElement;
import com.presta.utility.ConfigReader;
import com.presta.utility.UploadFile;
import com.presta.utility.Utility;

public class AddProductsPage extends Utility {
    AddProductsElement addProductsElement = new AddProductsElement();
    String adminEmail = ConfigReader.getProperty("adminUsername");
    String adminPassword = ConfigReader.getProperty("adminPassword");
    Faker faker = new Faker();

    public String addProductsPage() {
        sendKeyToElement(addProductsElement.userName, adminEmail);
        waits(2);
        sendKeyToElement(addProductsElement.password, adminPassword);
        waits(2);
        clickElement(addProductsElement.loginButton);
        waits(2);
        hoverOver(addProductsElement.catalogLink, 4);
        clickElement(addProductsElement.addProductLink);
        waits(2);
        clickElement(addProductsElement.addProductButton);
        waits(2);
        sendKeyToElement(addProductsElement.productName, faker.name().firstName());
        scrollTo(addProductsElement.saveAndStayButton);
        clickElement(addProductsElement.saveAndStayButton);
        waits(3);
        scrollToCenter(addProductsElement.imagesButton);
        clickElement(addProductsElement.imagesButton);
        waits(2);
        clickElement(addProductsElement.addFilesButton);
        waits(2);
        String filePath="/Users/mehmetgul/Desktop/test_image.jpeg";
        UploadFile.selectFileToUpload(filePath);
        waits(2);
        clickElement(addProductsElement.uploadFilesButton);
        System.out.println("addProductsElement.verifyUpload.getText() = " + addProductsElement.verifyUpload.getText());
        waits(2);
        scrollTo(addProductsElement.saveButton);
        clickElement(addProductsElement.saveButton);
        System.out.println("addProductsElement.successfulUpload.getText() = " + addProductsElement.successfulUpload.getText());
        waits(5);
        return addProductsElement.successfulUpload.getText();

    }
}
