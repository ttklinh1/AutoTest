package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import config.ConfigReader;
import utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverManager.getDriver();
    }

    // Locator
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By inventoryContainer = By.id("inventory_container");
    public static final String BASE_URL =
        ConfigReader.get("base.url");
    // Action
    public void open() {
        driver.get(BASE_URL);
    }

    public void enterUsername(String user) {
        WaitUtils.waitForElementVisible(username);
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        WaitUtils.waitForElementVisible(password);
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        WaitUtils.waitForElementVisible(loginBtn);
        driver.findElement(loginBtn).click();
    }

    public LoginPage login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
        return this;
    }

    public boolean isInventoryDisplayed() {
        WaitUtils.waitForElementVisible(inventoryContainer);
        return driver.findElement(inventoryContainer).isDisplayed();
    }
}