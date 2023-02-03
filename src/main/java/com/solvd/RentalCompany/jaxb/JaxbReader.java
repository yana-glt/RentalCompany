package com.solvd.RentalCompany.jaxb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxbReader {

    private final static Logger logger = LogManager.getLogger(JaxbReader.class);

    public static RentalCompany read(){
        try {
            JAXBContext context = JAXBContext.newInstance(RentalCompany.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader reader = new FileReader("src/main/java/com/solvd/RentalCompany/jaxb/company.xml");
            RentalCompany rentalCompany = (RentalCompany)unmarshaller.unmarshal(reader);
            System.out.println(rentalCompany);
            return rentalCompany;
        } catch (JAXBException e) {
            logger.error(String.format("Unmarshaller error"), e.getMessage());
            return null;
        } catch (FileNotFoundException e) {
            logger.error(String.format("Failed to read information from the specified file"), e.getMessage());
            return null;
        }
    }
}