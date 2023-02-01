package com.solvd.RentalCompany.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxbReader {

    public static void read(){
        try {
            JAXBContext context = JAXBContext.newInstance(RentalCompany.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader reader = new FileReader("C:/Users/Alexa/java projects/RentalCompany/src/main/java/com/solvd/RentalCompany/jaxb/company.xml");
            RentalCompany rentalCompany = (RentalCompany)unmarshaller.unmarshal(reader);
            System.out.println(rentalCompany);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}