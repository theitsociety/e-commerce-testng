package com.presta.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Driver1 {
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
    private static Logger logger = LoggerFactory.getLogger(Driver.class);

    private Driver1() {}

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            logEnvironmentInfo();
            String browser = getBrowserFromConfig();
            switch (BrowserType.valueOf(browser.toUpperCase())) {
                case CHROME:
                    setupChromeDriver();
                    break;
                case CHROME_HEADLESS:
                    setupChromeHeadlessDriver();
                    break;
                case FIREFOX:
                    setupFirefoxDriver();
                    break;
                case FIREFOX_HEADLESS:
                    setupFirefoxHeadlessDriver();
                    break;
                case IE:
                    setupInternetExplorerDriver();
                    break;
                case EDGE:
                    setupEdgeDriver();
                    break;
                case SAFARI:
                    setupSafariDriver();
                    break;
                case REMOTE_CHROME:
                    setupRemoteChromeDriver();
                    break;
                case REMOTE_FIREFOX:
                    setupRemoteFirefoxDriver();
                    break;
            }
        }
        return driverPool.get();
    }

    private static void setupRemoteFirefoxDriver() {
        FirefoxOptions firefoxOptions;
        try {
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("platform", Platform.ANY);
            driverPool.set(new RemoteWebDriver(new URL("http://localhost:4444//wd/hub"), firefoxOptions));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static FirefoxProfile firefoxProfile() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        try {
            firefoxProfile.setPreference("browser.download.folderList", 2);
            firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
            firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                    "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
        } catch (Exception e) {
            logger.error("Profile can't be configured for Firefox.", e);
        }
        return firefoxProfile;
    }

    public static void close() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }

    private static void logEnvironmentInfo() {
        logger.info("===============================================================");
        logger.info("|          Environment : " + ConfigReader.getProperty("env"));
        logger.info("|          Operating System : " + System.getProperty("os.name"));
        logger.info("|          Browser: " + ConfigReader.getProperty("browser"));
        logger.info("===============================================================");
    }

    private static String getBrowserFromConfig() {
        String browserParamFromEnv = System.getProperty("browser");
        return browserParamFromEnv == null ? ConfigReader.getProperty("browser") : browserParamFromEnv;
    }

    private static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        Map<String, Object> profile = new HashMap<>();
        Map<String, Object> contentSettings = new HashMap<>();

        contentSettings.put("cookies", ConfigReader.getProperty("cookiesEnableDisable"));
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");
        caps.setCapability(ChromeOptions.CAPABILITY, options);

        driverPool.set(new ChromeDriver(options));
    }

    private static void setupChromeHeadlessDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options1 = new ChromeOptions();
        options1.addArguments("--remote-allow-origins=*");
        driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
    }
    private static void setupFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(firefoxProfile());
        driverPool.set(new FirefoxDriver(firefoxOptions));
    }

    private static void setupFirefoxHeadlessDriver() {
        WebDriverManager.firefoxdriver().setup();
        driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
    }

    private static void setupInternetExplorerDriver() {
        if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
            throw new WebDriverException("Your OS doesn't support Internet Explorer");
        }
        WebDriverManager.iedriver().setup();
        driverPool.set(new InternetExplorerDriver());
    }

    private static void setupEdgeDriver() {
        if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
            throw new WebDriverException("Your OS doesn't support Edge");
        }
        WebDriverManager.edgedriver().setup();
        driverPool.set(new EdgeDriver());
    }
    private static void setupSafariDriver() {
        if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
            throw new WebDriverException("Your OS doesn't support Safari");

        }
        WebDriverManager.getInstance(SafariDriver.class).setup();
        driverPool.set(new SafariDriver());
    }
    private static void setupRemoteChromeDriver() {
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("platform", Platform.ANY);
            driverPool.set(new RemoteWebDriver(new URL("http://localhost:4444//wd/hub"), chromeOptions));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add similar private methods for other browser setups
}

enum BrowserType {
    CHROME,
    CHROME_HEADLESS,
    FIREFOX,
    FIREFOX_HEADLESS,
    IE,
    EDGE,
    SAFARI,
    REMOTE_CHROME,
    REMOTE_FIREFOX
}
