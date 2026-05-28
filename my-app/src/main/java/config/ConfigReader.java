package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {

        String env = System.getProperty("env");

        if (env == null) {
            env = "staging";
        }

        String fileName = "config/" + env + ".properties";

        try {

            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file: " + fileName);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}