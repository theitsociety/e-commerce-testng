package com.presta.tests.ui.admin.catalogs.products;

import com.presta.tests.testbase.TestBase;
import com.presta.utility.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddProductsTest extends TestBase {

    @Test
    public void addProducts(){
        String expectedResult="test_image.jpeg (4.31 KB)";
        String message="×\n" +
                "Successful update";
        String adminUrl= ConfigReader.getProperty("adminUrl");
        getAppLibrary().getFlowLibrary().navigateToUrl(adminUrl);
        String actualResult= getAppLibrary().getPage().getAddProductsPage().addProductsPage();
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);
        Assert.assertEquals(actualResult,message,"Assertion Failed");
    }

    @Test( groups = {"smoke", "regression"})
    @Parameters({"email", "password"})
    public void test2(@Optional String email, @Optional String password) {
        System.out.println("This is test2");
        System.out.println("email = " + email);
        System.out.println("password = " + password);

    }

}
