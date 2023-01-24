package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.CarService;
import com.solvd.RentalCompany.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class CarServiceDAO extends MySQLDAO implements ICarServiceDAO{
    private final static Logger logger = LogManager.getLogger(CarServiceDAO.class);
    @Override
    public CarService createEntity(CarService carService) {
        final String sqlQuery = "INSERT INTO carService (car_id, service_id, price, date) VALUES (?,?,?,?)";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);) {
            preparedStatement.setInt(1, carService.getCarId());
            preparedStatement.setInt(2, carService.getServiceId());
            preparedStatement.setDouble(3, carService.getPrice());
            preparedStatement.setObject(4, carService.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return carService;
    }

    @Override
    public Optional<CarService> getEntityById(Integer id) {
        final String sqlQuery = "SELECT id, car_id, service_id, price, date FROM carService WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer carServiceId = resultSet.getInt(1);
                    Integer carId = resultSet.getInt(2);
                    Integer serviceId = resultSet.getInt(3);
                    Double price = resultSet.getDouble(4);
                    LocalDate date = resultSet.getObject(5, LocalDate.class);
                    CarService carService = new CarService(carServiceId, carId, serviceId, price, date);
                    return Optional.of(carService);
                }
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public Optional<CarService> updateEntity(CarService carService, Integer id) {
        final String sqlQuery = "UPDATE carService SET car_id = ?, service_id = ?, price =?, date = ? WHERE id = ?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, carService.getCarId());
            preparedStatement.setInt(2, carService.getServiceId());
            preparedStatement.setDouble(3, carService.getPrice());
            preparedStatement.setObject(4, carService.getDate());
            preparedStatement.setInt(5, id);
            int n = preparedStatement.executeUpdate();
            if(n > 0){
                return Optional.of(carService);
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public void removeEntityById(Integer id) {
        final String sqlQuery = "DELETE FROM carService WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
    }
}