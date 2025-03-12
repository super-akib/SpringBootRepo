package com.nit.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class ConfigService {

    @Value("${database.url}")
    private String databaseUrl;

    @Value("${database.username}")
    private String databaseUserName;

    @Value("${database.password}")
    private String databasePassword;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.application.version}")
    private String applicationVersion;

    public void printDataBaseConfig() {
        System.out.println("Database Properties");
        System.out.println("--------------------");
        System.out.println("Database URL: " + databaseUrl);
        System.out.println("Database UserName: " + databaseUserName);
        System.out.println("Database password: " + databasePassword);
    }

    public void printApplicationConfig() {
        System.out.println("Application Configuration ");
        System.out.println("---------------------------");
        System.out.println("Application Name: " + applicationName);
        System.out.println("Version: " + applicationVersion);
    }

}
