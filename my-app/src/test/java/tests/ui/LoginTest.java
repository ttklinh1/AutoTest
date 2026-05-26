package tests.ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

//     private LoginPage login;

    @Test
    public void testLoginSuccess() {

        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        // Verify
        assert loginPage.isInventoryDisplayed();    }
}