package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.Employee;
import com.solvd.RentalCompany.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class EmployeeDAO extends MySQLDAO implements IEmployeeDAO{
    private final static Logger logger = LogManager.getLogger(EmployeeDAO.class);
    @Override
    public Employee createEntity(Employee employee) {
        final String sqlQuery = "INSERT INTO employee (name, surname, email, phone_number, salary, location_id, department_id) VALUES (?,?,?,?,?,?,?)";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setInt(6, employee.getLocationId());
            preparedStatement.setInt(7, employee.getDepartmentId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return employee;
    }

    @Override
    public Optional<Employee> getEntityById(Integer id) {
        final String sqlQuery = "SELECT id, name, surname, email, phone_number, salary, location_id, department_id FROM employee WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer employeeId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    String email = resultSet.getString(4);
                    String phone = resultSet.getString(5);
                    Double salary = resultSet.getDouble(6);
                    Integer locationId = resultSet.getInt(7);
                    Integer departmentId = resultSet.getInt(8);
                    Employee employee = new Employee(employeeId, name, surname, email, phone, salary, locationId, departmentId);
                    return Optional.of(employee);
                }
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Employee> updateEntity(Employee employee, Integer id) {
        final String sqlQuery = "UPDATE employee SET name = ?, surname = ?, email = ?, phone_number =?, salary = ?, location_id = ?, department_id = ? WHERE id = ?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(3, employee.getSurname());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setInt(6, employee.getLocationId());
            preparedStatement.setInt(7, employee.getDepartmentId());
            preparedStatement.setInt(8, id);
            int n = preparedStatement.executeUpdate();
            if(n > 0){
                return Optional.of(employee);
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public void removeEntityById(Integer id) {
        final String sqlQuery = "DELETE FROM employee WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
    }
}