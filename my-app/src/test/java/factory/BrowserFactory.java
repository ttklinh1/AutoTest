package factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {

    public static WebDriver createDriver(
            String browser)
            throws MalformedURLException {

        String executionType =
                System.getProperty(
                        "execution.type",
                        "local");

        if (executionType
                .equalsIgnoreCase(
                        "remote")) {

            return createRemoteDriver(
                    browser);
        }

        return createLocalDriver(
                browser);
    }

    private static WebDriver createLocalDriver(
        String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                 return createChromeDriver();
            case "firefox":
                return createFirefoxDriver();
            case "edge":
                return createEdgeDriver();
            default:
                throw new RuntimeException(
                        "Unsupported browser");
        }
    }

    private static WebDriver createRemoteDriver(
        String browser)
        throws MalformedURLException {
            String gridUrl =
                System.getProperty(
                        "grid.url",
                        "http://localhost:4444");
        URL url =
                new URL(gridUrl);
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chrome =
                            new ChromeOptions();
                   try {
                        return new RemoteWebDriver(
                                new URL("http://localhost:4444"),
                                chrome);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException("Grid URL is invalid", e);
                    }
                case "firefox":
                    FirefoxOptions firefox =
                            new FirefoxOptions();
                    try {
                        return new RemoteWebDriver(
                                new URL("http://localhost:4444"),
                                firefox);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException("Grid URL is invalid", e);
                    }
                case "edge":
                    EdgeOptions edge =
                            new EdgeOptions();
                    try {
                        return new RemoteWebDriver(
                                new URL("http://localhost:4444"),
                                edge);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException("Grid URL is invalid", e);
                    }
                default:
                    throw new RuntimeException(
                            "Unsupported browser");
            }
    }
    private static WebDriver createChromeDriver() {
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver createEdgeDriver() {
        return new EdgeDriver();
    }
}