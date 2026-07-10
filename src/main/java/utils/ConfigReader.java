package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load config.properties");
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException("Configuration key not found: " + key);
        }
        return value;
    }
}