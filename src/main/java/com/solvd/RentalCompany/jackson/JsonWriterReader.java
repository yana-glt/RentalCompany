package com.solvd.RentalCompany.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.solvd.RentalCompany.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;

public class JsonWriterReader {
    private final static Logger logger = LogManager.getLogger(JsonWriterReader.class);

    public static void writeToJson(RentalCompany rc){
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        defaultObjectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        defaultObjectMapper.registerModule(new JavaTimeModule());
        File file  = new File("src/main/java/com/solvd/RentalCompany/jackson/company.json");
        try {
            defaultObjectMapper.writeValue(file, rc);
        } catch (IOException e) {
            logger.error(String.format("Failed to read information from the specified file"), e.getMessage());
        }
    }

    public static <T> T readFromJson(String pathToFile, Class<T>clazz) {
        T obj = null;
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.registerModule(new JavaTimeModule());
        try {
            obj = defaultObjectMapper.readValue(new File(pathToFile),clazz);
        } catch (JsonProcessingException e) {
            logger.error(String.format("Failed to parse json file"), e.getMessage());
        } catch (IOException e) {
            logger.error(String.format("Failed to read information from the specified file"), e.getMessage());
        }
        return obj;
    }
}