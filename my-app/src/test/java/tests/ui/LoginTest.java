package tests.ui;

import dataproviders.LoginDataProvider;
import models.LoginData;

import org.slf4j.Logger;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest {

private static final Logger log =
        Log.getLogger(LoginPage.class);

    @Test(dataProvider = "loginUsers",
          dataProviderClass = LoginDataProvider.class)

    public void loginTest(LoginData user) {
        log.info("===== START LOGIN TEST =====");
    
        LoginPage loginPage =
                new LoginPage();
        loginPage.open();
        loginPage.login(
                user.getUsername(),
                user.getPassword());

        switch (user.getExpectedResult()) {

            case "success":
                log.info("Verify Home Page");
                assert loginPage.isInventoryDisplayed();
                break;

            case "locked":
                log.info("Verify Locked User");
                break;

            case "failed":
                log.info("Verify Failed Login");
                break;
        }
    }
}
