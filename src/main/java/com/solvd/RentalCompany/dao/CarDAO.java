package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.Car;
import com.solvd.RentalCompany.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.Optional;

public class CarDAO extends MySQLDAO implements ICarDAO{

    private final static Logger logger = LogManager.getLogger(CarDAO.class);
    @Override
    public Car createEntity(Car car) {
        final String sqlQuery = "INSERT INTO car (VIN, category_id, brand, model, number, year, day_price) VALUES (?,?,?,?,?,?,?)";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);) {
            preparedStatement.setString(1, car.getVin());
            preparedStatement.setString(2, car.getCategoryId());
            preparedStatement.setString(3, car.getBrand());
            preparedStatement.setString(4, car.getModel());
            preparedStatement.setString(5, car.getNumber());
            preparedStatement.setObject(6, car.getYear().getValue());
            preparedStatement.setDouble(7, car.getDayPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return car;
    }

    @Override
    public Optional<Car> getEntityById(Integer id) {
        final String sqlQuery = "SELECT id, VIN, category_id, brand, model, number, year, day_price FROM car WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer carId = resultSet.getInt(1);
                    String vin = resultSet.getString(2);
                    String categoryId = resultSet.getString(3);
                    String brand = resultSet.getString(4);
                    String model = resultSet.getString(5);
                    String number = resultSet.getString(6);
                    Year year = Year.of(resultSet.getInt(7));
                    Double dayPrice = resultSet.getDouble(8);
                    Car car = new Car(carId, vin, categoryId, brand, model, number, year, dayPrice);
                    return Optional.of(car);
                }
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Car> updateEntity(Car car, Integer id) {
        final String sqlQuery = "UPDATE car SET VIN = ?, category_id = ?, brand =?, model = ?, number = ?, year =?, day_price = ? WHERE id = ?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setString(1, car.getVin());
            preparedStatement.setString(2, car.getCategoryId());
            preparedStatement.setString(3, car.getBrand());
            preparedStatement.setString(4, car.getModel());
            preparedStatement.setString(5, car.getNumber());
            preparedStatement.setObject(6, car.getYear().getValue());
            preparedStatement.setDouble(7, car.getDayPrice());
            preparedStatement.setInt(8, id);
            int n = preparedStatement.executeUpdate();
            if(n > 0){
                return Optional.of(car);
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public void removeEntityById(Integer id) {
        final String sqlQuery = "DELETE FROM car WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
    }
}