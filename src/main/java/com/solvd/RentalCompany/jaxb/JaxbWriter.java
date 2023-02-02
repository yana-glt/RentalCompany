package com.solvd.RentalCompany.jaxb;

import com.solvd.RentalCompany.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.Year;

public class JaxbWriter {
    private final static Logger logger = LogManager.getLogger(JaxbWriter.class);
    public static void write(){
        try {
            JAXBContext context = JAXBContext.newInstance(RentalCompany.class);
            Marshaller m = context.createMarshaller();
            RentalCompany rentalCompany = new RentalCompany() {
                {
                    Service service = new Service(4,"WAT service","Warsaw","+48745468787","Poland");
                    this.addService(service);
                    service = new Service(5,"FAT service","Warsaw","+48520520630","Poland");
                    this.addService(service);
                    service = new Service(6,"RAT service","Warsaw","+48501548748","Poland");
                    this.addService(service);

                    CarService carService = new CarService(4,1, 4,1000.00, LocalDate.of(2022,11,05));
                    this.addCarService(carService);
                    carService = new CarService(5,2,5,2000.00, LocalDate.of(2022, 10, 10));
                    this.addCarService(carService);
                    carService = new CarService(6,3,6,3000.00, LocalDate.of(2022, 12, 15));
                    this.addCarService(carService);

                    Car car = new Car(1, "XLM8592KM00152L56", "A", "Kia", "Picanto", "RJA4198", Year.of(2020), 100.00);
                    this.addCar(car);
                    car = new Car(2, "PKT001KW945444878", "A", "Fiat", "500", "PLO7003", Year.of(2019), 115.00);
                    this.addCar(car);
                    car = new Car(3, "LTY9003HY8521P961", "B", "VolksWagen", "Polo", "PLO7003", Year.of(2019), 130.00);
                    this.addCar(car);

                    Category category = new Category("A", "mini cars", "Smaller than 370 cm in length.",1.20);
                    this.addCategory(category);
                    category = new Category("B", "small cars","Sizes range from 370 cm to 400 cm. ", 1.30);
                    this.addCategory(category);

                    TechnicalInspection technicalInspection = new TechnicalInspection(1,1, LocalDate.of(2022,11,05), "SGS Poland Sp. z o.o.");
                    this.addTechnicalInspection(technicalInspection);
                    technicalInspection = new TechnicalInspection(2,2, LocalDate.of(2022, 10, 10), "SGS Poland Sp. z o.o.");
                    this.addTechnicalInspection(technicalInspection);
                    technicalInspection = new TechnicalInspection(3,3, LocalDate.of(2022, 12, 15), "SGS Poland Sp. z o.o.");
                    this.addTechnicalInspection(technicalInspection);
                }
            };
            m.marshal(rentalCompany, new FileOutputStream("C:/Users/Alexa/java projects/RentalCompany/src/main/java/com/solvd/RentalCompany/jaxb/company.xml"));
        } catch (JAXBException e) {
            logger.error(String.format("Unmarshaller error"), e.getMessage());
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            logger.error(String.format("Failed to read information from the specified file"), e.getMessage());
        }
    }
}