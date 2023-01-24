package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.TechnicalInspection;
import com.solvd.RentalCompany.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class TechnicalInspectionDAO extends MySQLDAO implements ITechnicalInspectionDAO{

    private final static Logger logger = LogManager.getLogger(TechnicalInspectionDAO.class);
    @Override
    public TechnicalInspection createEntity(TechnicalInspection technicalInspection) {
        final String sqlQuery = "INSERT INTO technicalInspection (car_id, date, organization) VALUES (?,?,?)";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);) {
            preparedStatement.setInt(1, technicalInspection.getCarId());
            preparedStatement.setObject(2, technicalInspection.getDate());
            preparedStatement.setString(3, technicalInspection.getOrganization());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return technicalInspection;
    }

    @Override
    public Optional<TechnicalInspection> getEntityById(Integer id) {
        final String sqlQuery = "SELECT id, car_id, date, organization FROM technicalInspection WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer technicalInspectionId = resultSet.getInt(1);
                    Integer carId = resultSet.getInt(2);
                    LocalDate date = resultSet.getObject(3, LocalDate.class);
                    String organization = resultSet.getString(4);
                    TechnicalInspection technicalInspection = new TechnicalInspection(technicalInspectionId, carId, date, organization);
                    return Optional.of(technicalInspection);
                }
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public Optional<TechnicalInspection> updateEntity(TechnicalInspection technicalInspection, Integer id) {
        final String sqlQuery = "UPDATE technicalInspection SET car_id = ?, date = ?, organization =? WHERE id = ?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, technicalInspection.getCarId());
            preparedStatement.setObject(2, technicalInspection.getDate());
            preparedStatement.setString(3, technicalInspection.getOrganization());
            preparedStatement.setInt(4, id);
            int n = preparedStatement.executeUpdate();
            if(n > 0){
                return Optional.of(technicalInspection);
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public void removeEntityById(Integer id) {
        final String sqlQuery = "DELETE FROM technicalInspection WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
    }
}