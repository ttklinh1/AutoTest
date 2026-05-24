package tests.ui;

import base.BaseTest;
import driver.DriverManager;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
    public void testGoogle() {
        DriverManager.getDriver().get("https://google.com");
        String title = DriverManager.getDriver().getTitle();
        assert title.contains("Google");
    }
}