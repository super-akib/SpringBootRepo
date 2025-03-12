package com.nit.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
@PropertySource("application.properties")
public class ConfigService {

    @Value("${database.url}")
    private String databaseUrl;

    @Value("${database.username}")
    private String databaseUsername;

    @Value("${database.password}")
    private String databasePassword;

    @Value("${product.name}")
    private String productName;

    @Value("${product.price}")
    private Double productPrice;

    @Value("${product.description}")
    private String productDescription;

    public void printDatabaseConfig() {
        System.out.println("Database URL: " + databaseUrl);
        System.out.println("Database Username: " + databaseUsername);
        System.out.println("Database Password: " + databasePassword);
    }

    public void printProductConfig() {
        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + productPrice);
        System.out.println("Product Description: " + productDescription);
    }

    public void storeProductConfigInDatabase() {
        try (Connection connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword)) {
            String sql = "INSERT INTO products (name, price, description) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, productName);
                preparedStatement.setDouble(2, productPrice);
                preparedStatement.setString(3, productDescription);
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("Product inserted successfully. Rows affected: " + rowsAffected);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
