package org.example.config;

public class ConfigManager {
    private ConfigManager() {}
    private static final ConfigManager INSTANCE = new ConfigManager();

    public static ConfigManager getInstance(){
        return INSTANCE;
    }

    private final String dbUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true";
    private final String dbUsername = "root";
    private final String dbPassword = "0000";

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }
}
