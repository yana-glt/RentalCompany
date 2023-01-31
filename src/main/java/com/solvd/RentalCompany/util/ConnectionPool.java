package com.solvd.RentalCompany.util;

import com.solvd.RentalCompany.dao.ServiceDAO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
    private final static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static Properties properties = new Properties();;
    private static BasicDataSource dataSource;
    static{
        try {
            properties.load(new FileInputStream("src/main/resources/database.properties"));
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(properties.getProperty("dbDriver"));
            dataSource.setUrl(properties.getProperty("dbUrl"));
            dataSource.setUsername(properties.getProperty("dbUser"));
            dataSource.setPassword(properties.getProperty("dbPass"));

            dataSource.setMinIdle(5);
            dataSource.setMaxIdle(10);
            dataSource.setMaxOpenPreparedStatements(100);

        } catch (IOException e) {
            logger.error(String.format("Failed to read information from database.properties file"), e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private ConnectionPool(){ }
}