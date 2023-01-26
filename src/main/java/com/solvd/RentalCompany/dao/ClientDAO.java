package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.Client;
import com.solvd.RentalCompany.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ClientDAO extends MySQLDAO implements IClientDAO{
    private final static Logger logger = LogManager.getLogger(ClientDAO.class);
    @Override
    public Client createEntity(Client client) {
        final String sqlQuery = "INSERT INTO client (name, surname, email, phone_number) VALUES (?,?,?,?)";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return client;
    }

    @Override
    public Optional<Client> getEntityById(Integer id) {
        final String sqlQuery = "SELECT id, name, surname, email, phone_number FROM client WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer clientId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    String email = resultSet.getString(4);
                    String phone = resultSet.getString(5);
                    Client client = new Client(clientId, name, surname, email, phone);
                    return Optional.of(client);
                }
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Client> updateEntity(Client client, Integer id) {
        final String sqlQuery = "UPDATE client SET name = ?, surname = ?, email = ?, phone_number =? WHERE id = ?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(3, client.getSurname());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.setInt(5, id);
            int n = preparedStatement.executeUpdate();
            if(n > 0){
                return Optional.of(client);
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public void removeEntityById(Integer id) {
        final String sqlQuery = "DELETE FROM client WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
    }
}