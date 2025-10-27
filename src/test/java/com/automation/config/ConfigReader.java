package com.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            String path = "src/test/resources/configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
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
