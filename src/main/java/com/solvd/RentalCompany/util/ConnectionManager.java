package com.solvd.RentalCompany.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private final static Logger logger = LogManager.getLogger(ConnectionManager.class);
    private static ConnectionManager instance;
    private Connection connection;
    private ConnectionManager(){
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/database.properties"));
            String url = properties.getProperty("dbUrl");
            String user = properties.getProperty("dbUser");
            String pwd = properties.getProperty("dbPass");
            this.connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        } catch (FileNotFoundException e) {
            logger.error(String.format("Failed to read information from database.properties file"), e);
        } catch (IOException e) {
            logger.error(String.format("Failed to read information from database.properties file"), e);
        }
    }

    public void close(){
        if(this.connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Database error", e.getMessage(), e.getErrorCode());
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionManager getInstance(){
        try{
            if(instance == null || instance.connection.isClosed()){
                synchronized (ConnectionManager.class){
                    if(instance == null || instance.connection.isClosed()){
                        instance = new ConnectionManager();
                    }
                }
            }
        }catch(SQLException e){
            logger.error("Database error", e.getMessage(), e.getErrorCode());
        }
        return instance;
    }
}
