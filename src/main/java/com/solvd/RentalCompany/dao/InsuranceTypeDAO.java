package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.InsuranceType;
import com.solvd.RentalCompany.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class InsuranceTypeDAO extends MySQLDAO implements IInsuranceTypeDAO{

    private final static Logger logger = LogManager.getLogger(InsuranceTypeDAO.class);
    @Override
    public InsuranceType createEntity(InsuranceType insuranceType) {
        final String sqlQuery = "INSERT INTO insuranceType (category_id, mandatory_insurance_price, additional_insurance_price) VALUES (?,?,?)";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);) {
            preparedStatement.setString(1, insuranceType.getCategoryId());
            preparedStatement.setDouble(2, insuranceType.getMandatoryPrice());
            preparedStatement.setDouble(3, insuranceType.getAdditionalPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return insuranceType;
    }

    @Override
    public Optional<InsuranceType> getEntityById(Integer id) {
        final String sqlQuery = "SELECT id, category_id, mandatory_insurance_price, additional_insurance_price FROM insuranceType WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer insuranceTypeId = resultSet.getInt(1);
                    String categoryId = resultSet.getString(2);
                    Double mandatoryPrice = resultSet.getDouble(3);
                    Double additionalPrice = resultSet.getDouble(4);
                    InsuranceType insuranceType = new InsuranceType(insuranceTypeId, categoryId, mandatoryPrice, additionalPrice);
                    return Optional.of(insuranceType);
                }
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public Optional<InsuranceType> updateEntity(InsuranceType insuranceType, Integer id) {
        final String sqlQuery = "UPDATE insuranceType SET category_id = ?, mandatory_insurance_price = ?, additional_insurance_price =? WHERE id = ?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setString(1, insuranceType.getCategoryId());
            preparedStatement.setDouble(2, insuranceType.getMandatoryPrice());
            preparedStatement.setDouble(3, insuranceType.getAdditionalPrice());
            preparedStatement.setInt(4, id);
            int n = preparedStatement.executeUpdate();
            if(n > 0){
                return Optional.of(insuranceType);
            }
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return Optional.empty();
    }

    @Override
    public void removeEntityById(Integer id) {
        final String sqlQuery = "DELETE FROM insuranceType WHERE id=?";
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
    }
}