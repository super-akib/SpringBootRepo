package com.nit.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nit.model.User;

@Component
public class UserDao {

    @Autowired
    private DataSource dataSource;

    // Here data will be inserted into credit card table
    public int insertDataInCreditCard(User user) {
        int i = 0;
        String sql = "INSERT INTO CREDIT_CARD_DETAILS (USER_ID, USER_NAME, MAILID) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getEmailId());

            i = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();  // Consider using a logger here
        }

        return i;
    }

    // Here data will be inserted into PayPal table
    public int insertDataInPaypal(User user) {
        int i = 0;
        String sql = "INSERT INTO PAPAL_PAYMENT_DETAILS (USER_ID, USER_NAME, MAILID) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getEmailId());

            i = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();  // Consider using a logger here
        }

        return i;
    }
}
