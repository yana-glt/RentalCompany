package com.solvd.RentalCompany.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBConfigUtil {

    private final static Logger logger = LogManager.getLogger(DBConfigUtil.class);

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileReader("database.properties"));
        } catch (FileNotFoundException e) {
            logger.error("Failed to read information from database.properties file", e);
        } catch (IOException e) {
            logger.error("Exception while loading database.properties file", e);
        }
    }

    private DBConfigUtil() {

    }

    public static Properties getProperties() {
        return properties;
    }
}