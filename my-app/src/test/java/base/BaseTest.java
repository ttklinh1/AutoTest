package base;

import driver.DriverManager;
import factory.BrowserFactory;
import pages.LoginPage;
import utils.Log;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    private static final Logger log =
        Log.getLogger(LoginPage.class);
        
    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setup(
            @Optional("chrome") String browser) {

        String browserName =
                System.getProperty("browser", browser);

        WebDriver driver =
                BrowserFactory.createDriver(browserName);

        DriverManager.setDriver(driver);

        DriverManager.getDriver()
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        DriverManager.getDriver()
                .manage()
                .window()
                .maximize();

        log.info(
                "Thread ID: "
                        + Thread.currentThread().getId()
                        + " | Browser: "
                        + browserName);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverManager.quitDriver();
    }

    protected WebDriver getDriver() {

        return DriverManager.getDriver();
    }
}