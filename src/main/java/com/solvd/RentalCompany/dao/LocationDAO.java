package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.Location;
import com.solvd.RentalCompany.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class LocationDAO extends MySQLDAO implements ILocationDAO{
    private final static Logger logger = LogManager.getLogger(LocationDAO.class);
    @Override
    public Location createEntity(Location location) {
        final String sqlQuery = "INSERT INTO location (name, phone_number, address, country) VALUES (?,?,?,?)";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);) {
            preparedStatement.setString(1, location.getName());
            preparedStatement.setString(2, location.getAddress());
            preparedStatement.setString(3, location.getPhone());
            preparedStatement.setString(4, location.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return location;
    }

    @Override
    public Optional<Location> getEntityById(Integer id) {
        final String sqlQuery = "SELECT id, name, phone_number, address, country FROM location WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer locationId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String phone = resultSet.getString(4);
                    String address = resultSet.getString(3);
                    String country = resultSet.getString(5);
                    Location location = new Location(locationId, name, phone, address, country);
                    return Optional.of(location);
                }
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Location> updateEntity(Location location, Integer id) {
        final String sqlQuery = "UPDATE location SET name = ?, phone_number =?, address = ?,country = ? WHERE id = ?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setString(1, location.getName());
            preparedStatement.setString(3, location.getPhone());
            preparedStatement.setString(2, location.getAddress());
            preparedStatement.setString(4, location.getCountry());
            preparedStatement.setInt(5, id);
            int n = preparedStatement.executeUpdate();
            if(n > 0){
                return Optional.of(location);
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public void removeEntityById(Integer id) {
        final String sqlQuery = "DELETE FROM location WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
    }
}