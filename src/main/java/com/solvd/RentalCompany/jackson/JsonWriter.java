package com.solvd.RentalCompany.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.solvd.RentalCompany.models.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;

public class JsonWriter {
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
       }
   }
}
