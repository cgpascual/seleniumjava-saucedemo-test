package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.LoggerUtils;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        LoggerUtils.info("Starting browser");
        DriverFactory.initializeDriver();

        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("url"));
        LoggerUtils.info("Navigated to SauceDemo");
    }

    @AfterMethod
    public void tearDown() {
        LoggerUtils.info(
                "Closing browser"
        );

        DriverFactory.quitDriver();
    }
}