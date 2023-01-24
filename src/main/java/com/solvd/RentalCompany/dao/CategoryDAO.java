package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.Category;
import com.solvd.RentalCompany.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CategoryDAO extends MySQLDAO implements ICategoryDAO{

    private final static Logger logger = LogManager.getLogger(CategoryDAO.class);
    @Override
    public Category createEntity(Category category) {
        final String sqlQuery = "INSERT INTO category (id, name, description, coefficient) VALUES (?,?,?,?)";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);) {
            preparedStatement.setString(1, category.getId());
            preparedStatement.setString(2, category.getName());
            preparedStatement.setString(3, category.getDescription());
            preparedStatement.setDouble(4, category.getCoefficient());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return category;
    }

    @Override
    public Optional<Category> getEntityById(String id) {
        final String sqlQuery = "SELECT id, name, description, coefficient FROM category WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setString(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String categoryId = resultSet.getString(1);
                    String name = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    Double coefficient = resultSet.getDouble(4);
                    Category category = new Category(categoryId, name, description, coefficient);
                    return Optional.of(category);
                }
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Category> updateEntity(Category category, String id) {
        final String sqlQuery = "UPDATE category SET name = ?, description = ?, coefficient =? WHERE id = ?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setDouble(3, category.getCoefficient());
            preparedStatement.setString(4, id);
            int n = preparedStatement.executeUpdate();
            if(n > 0){
                return Optional.of(category);
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public void removeEntityById(String id) {
        final String sqlQuery = "DELETE FROM category WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
    }
}