package com.solvd.RentalCompany.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
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
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        if(this.connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
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
            e.printStackTrace();
        }
        return instance;
    }
}
