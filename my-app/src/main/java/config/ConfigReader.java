package config;

public class ConfigReader {
    public static String get(String key) {
        switch (key) {
            case "base.url":
                return "https://www.saucedemo.com";
            default:
                throw new IllegalArgumentException("Unknown config key: " + key);
        }
    }
}
