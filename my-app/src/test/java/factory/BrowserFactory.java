package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    public static WebDriver createDriver(String browser) {

        switch (browser.toLowerCase()) {

            case "chrome":
                return createChromeDriver();

            case "firefox":
                return createFirefoxDriver();

            case "edge":
                return createEdgeDriver();

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser);
        }
    }

    private static WebDriver createChromeDriver() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver() {

        FirefoxOptions options = new FirefoxOptions();

        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver() {

        EdgeOptions options = new EdgeOptions();

        return new EdgeDriver(options);
    }
}