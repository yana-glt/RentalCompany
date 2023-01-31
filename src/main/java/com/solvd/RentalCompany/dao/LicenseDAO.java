package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.License;
import com.solvd.RentalCompany.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class LicenseDAO extends MySQLDAO implements ILicenseDAO{
    private final static Logger logger = LogManager.getLogger(LicenseDAO.class);
    @Override
    public License createEntity(License license) {
        final String sqlQuery = "INSERT INTO license (client_id, number, issue_date, expiry_date, is_valid) VALUES (?,?,?,?,?)";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);) {
            preparedStatement.setInt(1, license.getClientId());
            preparedStatement.setString(2, license.getNumber());
            preparedStatement.setObject(3, license.getIssueDate());
            preparedStatement.setObject(4, license.getExpiryDate());
            preparedStatement.setBoolean(5, license.getValid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return license;
    }

    @Override
    public Optional<License> getEntityById(Integer id) {
        final String sqlQuery = "SELECT id, client_id, number, issue_date, expiry_date, is_valid FROM license WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer licenseId = resultSet.getInt(1);
                    Integer clientId = resultSet.getInt(2);
                    String number = resultSet.getString(3);
                    LocalDate issueDate = resultSet.getObject(4, LocalDate.class);
                    LocalDate expiryDate = resultSet.getObject(5, LocalDate.class);
                    Boolean isValid = resultSet.getBoolean(6);
                    License license = new License(licenseId, clientId, number, issueDate, expiryDate,isValid);
                    return Optional.of(license);
                }
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public Optional<License> updateEntity(License license, Integer id) {
        final String sqlQuery = "UPDATE license SET client_id = ?, number = ?, issue_date =?, expiry_date = ?, is_valid = ? WHERE id = ?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, license.getClientId());
            preparedStatement.setString(2, license.getNumber());
            preparedStatement.setObject(3, license.getIssueDate());
            preparedStatement.setObject(4, license.getExpiryDate());
            preparedStatement.setBoolean(5, license.getValid());
            preparedStatement.setInt(6, id);
            int n = preparedStatement.executeUpdate();
            if(n > 0){
                return Optional.of(license);
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public void removeEntityById(Integer id) {
        final String sqlQuery = "DELETE FROM license WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
    }
}