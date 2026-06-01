package tests.ui;

import base.BaseTest;

import org.slf4j.Logger;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest {

private static final Logger log =
        Log.getLogger(LoginPage.class);
    @Test
    public void testLoginSuccess() {
        log.info("===== START LOGIN TEST =====");
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        // Verify
        log.info("Verify Home Page");
        assert loginPage.isInventoryDisplayed();    
        log.info("===== TEST PASSED =====");
    }
}