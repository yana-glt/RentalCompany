package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.Reservation;
import com.solvd.RentalCompany.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class ReservationDAO extends MySQLDAO implements IReservationDAO{
    private final static Logger logger = LogManager.getLogger(ReservationDAO.class);
    @Override
    public Reservation createEntity(Reservation reservation) {
        final String sqlQuery = "INSERT INTO reservation (client_id, employee_id, car_id, insurance_id, from_date, to_date, price) VALUES (?,?,?,?,?,?,?)";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);) {
            preparedStatement.setInt(1, reservation.getClientId());
            preparedStatement.setInt(2, reservation.getEmployeeId());
            preparedStatement.setInt(3, reservation.getCarId());
            preparedStatement.setInt(4, reservation.getInsuranceId());
            preparedStatement.setObject(5, reservation.getFromDate());
            preparedStatement.setObject(6, reservation.getToDate());
            if(reservation.getToDate() != null){preparedStatement.setObject(6, reservation.getToDate());}
            else{preparedStatement.setObject(6, null);}
            if(reservation.getPrice() != null){preparedStatement.setDouble(7, reservation.getPrice());}
            else{preparedStatement.setDouble(7, 0.00);}
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return reservation;
    }

    @Override
    public Optional<Reservation> getEntityById(Integer id) {
        final String sqlQuery = "SELECT id, client_id, employee_id, car_id, insurance_id, from_date, to_date, price FROM reservation WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer reservationId = resultSet.getInt(1);
                    Integer clientId = resultSet.getInt(2);
                    Integer employeeId = resultSet.getInt(3);
                    Integer carId = resultSet.getInt(4);
                    Integer insuranceId = resultSet.getInt(5);
                    LocalDate fromDate = resultSet.getObject(6, LocalDate.class);
                    LocalDate toDate = resultSet.getObject(7, LocalDate.class);
                    Double price = resultSet.getDouble(8);
                    Reservation reservation = new Reservation(reservationId, clientId, employeeId, carId, insuranceId, fromDate, toDate, price);
                    return Optional.of(reservation);
                }
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Reservation> updateEntity(Reservation reservation, Integer id) {
        final String sqlQuery = "UPDATE reservation SET client_id = ?, employee_id = ?, car_id = ?, insurance_id = ?, from_date = ?, to_date = ?, price =? WHERE id = ?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, reservation.getClientId());
            preparedStatement.setInt(2, reservation.getEmployeeId());
            preparedStatement.setInt(3, reservation.getCarId());
            preparedStatement.setInt(4, reservation.getInsuranceId());
            preparedStatement.setObject(5, reservation.getFromDate());
            preparedStatement.setObject(6, reservation.getToDate());
            preparedStatement.setDouble(7, reservation.getPrice());
            preparedStatement.setInt(8, id);
            int n = preparedStatement.executeUpdate();
            if(n > 0){
                return Optional.of(reservation);
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public void removeEntityById(Integer id) {
        final String sqlQuery = "DELETE FROM reservation WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
    }
}