package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfProperties {
    public static String getProperty(String property) {
        Properties properties = new Properties();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("conf.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }
}