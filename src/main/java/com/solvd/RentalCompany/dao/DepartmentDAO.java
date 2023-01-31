package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.Department;
import com.solvd.RentalCompany.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DepartmentDAO extends MySQLDAO implements IDepartmentDAO{
    private final static Logger logger = LogManager.getLogger(DepartmentDAO.class);
    @Override
    public Department createEntity(Department department) {
        final String sqlQuery = "INSERT INTO department (name, min_salary, max_salary) VALUES (?,?,?)";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);) {
            preparedStatement.setString(1, department.getName());
            preparedStatement.setDouble(2, department.getMinSalary());
            preparedStatement.setDouble(3, department.getMaxSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return department;
    }

    @Override
    public Optional<Department> getEntityById(Integer id) {
        final String sqlQuery = "SELECT id, name, min_salary, max_salary FROM department WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer departmentId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    Double minSalary = resultSet.getDouble(3);
                    Double maxSalary = resultSet.getDouble(4);
                    Department department = new Department(departmentId, name, minSalary, maxSalary);
                    return Optional.of(department);
                }
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Department> updateEntity(Department department, Integer id) {
        final String sqlQuery = "UPDATE department SET name = ?, min_salary = ?, max_salary =? WHERE id = ?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setString(1, department.getName());
            preparedStatement.setDouble(2, department.getMinSalary());
            preparedStatement.setDouble(3, department.getMaxSalary());
            preparedStatement.setInt(4, id);
            int n = preparedStatement.executeUpdate();
            if(n > 0){
                return Optional.of(department);
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public void removeEntityById(Integer id) {
        final String sqlQuery = "DELETE FROM department WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
    }
}