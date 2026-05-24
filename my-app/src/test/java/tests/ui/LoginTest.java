package tests.ui;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverManager;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginSuccess() {

        // Open website
        DriverManager.getDriver().get("https://www.saucedemo.com/");

        // Input username
        DriverManager.getDriver().findElement(By.id("user-name"))
                .sendKeys("standard_user");

        // Input password
        DriverManager.getDriver().findElement(By.id("password"))
                .sendKeys("secret_sauce");

        // Click login
        DriverManager.getDriver().findElement(By.id("login-button"))
                .click();
    }
}
