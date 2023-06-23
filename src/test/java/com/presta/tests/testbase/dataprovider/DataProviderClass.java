package com.presta.tests.testbase.dataprovider;

import com.github.javafaker.Faker;
import com.presta.utility.excel.ReadExcelLib;
import org.testng.annotations.DataProvider;

import java.io.File;

public class DataProviderClass {


    @DataProvider(name = "newUserData")
    public Object[][] newUserData() {
        return new Object[][]{
                {"yyy@gmail.com", "Johnq", "Doew", "test1234"},
                {"nnn@gmail.com", "Maryq", "Janew", "test1234"},
                {"vvv@gmail.com", "Jackq", "Jaksonw", "test1234"},
                {"gggg@gmail.com", "Rahulq", "Shettyw", "test1234"},
        };
    }

    @DataProvider(name = "oldUserData")
    public Object[][] oldUserDataxxxxxxxxxxsssssssss() {
        return new Object[][]{
                {"bbbb@gmail.com", "Johnq", "Doew", "test1234"},
                {"ggg@gmail.com", "Maryq", "Janew", "test1234"},
                {"tttt@gmail.com", "Jackq", "Jaksonw", "test1234"},
                {"hhhh@gmail.com", "Rahulq", "Shettyw", "test1234"},
        };
    }

    @DataProvider(name = "dataWithFaker")
    public Object[][] oldUserDataFaker() {
        String password = "test1234";
        return new Object[][]{
                {new Faker().internet().emailAddress(), new Faker().name().firstName(), new Faker().name().lastName(), password},
                {new Faker().internet().emailAddress(), new Faker().name().firstName(), new Faker().name().lastName(), password},
                {new Faker().internet().emailAddress(), new Faker().name().firstName(), new Faker().name().lastName(), password},
                {new Faker().internet().emailAddress(), new Faker().name().firstName(), new Faker().name().lastName(), password},
        };
    }

    ReadExcelLib excelLib = new ReadExcelLib();

    @DataProvider(name = "getDataFromExcel")
    public Object[][] readDataFromExcelFile() {
        String filePath = System.getProperty("user.dir") + File.separator + "src/test/resources/excelfiles/TestData.xlsx";
        return excelLib.get_Excel_Data(filePath,"userdetails",4);
    }


}
