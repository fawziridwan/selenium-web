package com.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        String path = "src/test/resources/configuration.properties";
        try (FileInputStream input = new FileInputStream(path)) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration.properties file from path: " + path, e);
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property not found in configuration.properties: " + key);
        }
        return value;
    }

    public static String getBaseUrl() {
        return getProperty("base_url");
    }

    public static String getBrowser() {
        return getProperty("browser");
    }

    public static String getHeadless() {
        return getProperty("headless");
    }

    public static int getImplicitTimeout() {
        return Integer.parseInt(getProperty("implicit_timeout"));
    }

    public static int getExplicitTimeout() {
        return Integer.parseInt(getProperty("explicit_timeout"));
    }

    public static int getPageLoadTimeout() {
        return Integer.parseInt(getProperty("page_load_timeout"));
    }
}
