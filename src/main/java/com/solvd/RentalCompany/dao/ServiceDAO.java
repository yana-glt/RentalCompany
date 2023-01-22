package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.Service;
import com.solvd.RentalCompany.util.ConnectionManager;
import com.solvd.RentalCompany.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class ServiceDAO extends MySQLDAO implements IServiceDAO{
    private final static Logger logger = LogManager.getLogger(ServiceDAO.class);

    @Override
    public Service createEntity(Service service) {
        final String sqlQuery = "INSERT INTO Services (name, address, phone, country) VALUES (?,?,?,?)";

        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);) {
            preparedStatement.setString(1, service.getName());
            preparedStatement.setString(2, service.getAddress());
            preparedStatement.setString(3, service.getPhone());
            preparedStatement.setString(4, service.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return service;
    }

    @Override
    public Optional<Service> getEntityById(Integer id) {
        final String sqlQuery = "SELECT service_id, name, address, phone, country FROM Services WHERE service_id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer serviceId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String address = resultSet.getString(3);
                    String phone = resultSet.getString(4);
                    String country = resultSet.getString(5);
                    Service service = new Service(serviceId, name, address, phone, country);
                    return Optional.of(service);
                }
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Service> updateEntity(Service service, Integer id) {
        final String sqlQuery = "UPDATE Services SET name = ?, address = ?, phone =?, country = ? WHERE service_id = ?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setString(1, service.getName());
            preparedStatement.setString(2, service.getAddress());
            preparedStatement.setString(3, service.getPhone());
            preparedStatement.setString(4, service.getCountry());
            preparedStatement.setInt(5, id);
            int n = preparedStatement.executeUpdate();
            if(n > 0){
                return Optional.of(service);
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public void removeEntityById(Integer id) {
        final String sqlQuery = "DELETE FROM Services WHERE service_id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
    }
}
