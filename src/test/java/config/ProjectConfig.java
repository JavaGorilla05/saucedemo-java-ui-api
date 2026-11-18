package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProjectConfig {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ProjectConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("config.properties not found in classpath");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public static String getBrowser() {
        return properties.getProperty("browser", "chrome");
    }

    public static String getBrowserSize() {
        return properties.getProperty("browserSize", "1920x1080");
    }

    public static boolean isRemote() {
        return Boolean.parseBoolean(properties.getProperty("isRemote", "false"));
    }

    public static String getRemoteUrl() {
        return properties.getProperty("remoteUrl");
    }
}
