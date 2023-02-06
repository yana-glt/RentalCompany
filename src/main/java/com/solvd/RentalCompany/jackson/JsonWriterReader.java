package com.solvd.RentalCompany.jackson;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.solvd.RentalCompany.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class JsonWriterReader {
    private final static Logger logger = LogManager.getLogger(JsonWriterReader.class);
    private static ObjectMapper objectMapper= getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        defaultObjectMapper.registerModule(new JavaTimeModule());
        defaultObjectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        return defaultObjectMapper;
    }

    public static void writeToJson(RentalCompany rc){
        try {
            objectMapper.writeValue(new File("src/main/java/com/solvd/RentalCompany/jackson/company.json"), rc);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(String.format("Failed to read information from the specified file"), e.getMessage());
        }
    }

    public static RentalCompany readFromJson() {
        RentalCompany rc = new RentalCompany();
        File file  = new File("src/main/java/com/solvd/RentalCompany/jackson/company.json");
        try {
            rc = objectMapper.readValue(new File("src/main/java/com/solvd/RentalCompany/jackson/company.json"), RentalCompany.class);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(String.format("Failed to read information from the specified file"), e.getMessage());
        }
        return rc;
    }
}