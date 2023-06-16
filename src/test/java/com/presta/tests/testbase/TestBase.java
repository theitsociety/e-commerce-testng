package com.presta.tests.testbase;

import com.presta.utility.Driver;
import com.presta.utility.library.AppLibrary;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestBase {
    AppLibrary appLibrary;

    public TestBase(){
        appLibrary = new AppLibrary();
    }

    public AppLibrary getAppLibrary() {
        return appLibrary;
    }

    @BeforeMethod(alwaysRun = true, groups = {"smoke", "regression"},
            onlyForGroups = {"smoke", "regression"})
    synchronized public void browserSetup() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        appLibrary = new AppLibrary();
    }

    @BeforeMethod(onlyForGroups = {"data"}, alwaysRun = true)
    synchronized public void dataLoad() {
        System.out.println("Data Loading started");
        List<String> data = new ArrayList<>();
    }

    @BeforeMethod(onlyForGroups = {"dbConnection", "db"}, alwaysRun = true)
    synchronized public void dataconnection() {
        System.out.println("Database connection started");

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("After Method called");
        Driver.close();
    }
}
