package com.solvd.RentalCompany;

import com.solvd.RentalCompany.core.CarServiceCore;
import com.solvd.RentalCompany.core.ServiceCore;
import com.solvd.RentalCompany.services.CarServiceService;
import com.solvd.RentalCompany.services.ICarServiceService;
import com.solvd.RentalCompany.services.IServiceService;
import com.solvd.RentalCompany.services.ServiceService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        IServiceService serviceService = new ServiceService();
//      serviceService.createEntity(new ServiceCore("FFF", "FFF", "+48962620520", "Spain"));
//      serviceService.createEntity(new ServiceCore("DDD", "DDD", "+48962620520", "USA"));

//      System.out.println(serviceService.getEntityById(1));
//      System.out.println(serviceService.getEntityById(2));
//      System.out.println(serviceService.getEntityById(6));

//      serviceService.updateEntity(new ServiceCore("OOO", "SSS", "+48962620520", "Spain"), 7);
//      serviceService.updateEntity(new ServiceCore("LLL", "SSS", "+48962620520", "Spain"), 8);

//      serviceService.removeEntityById(7);
//      serviceService.removeEntityById(8);

        ICarServiceService carServiceService = new CarServiceService();
//      carServiceService.createEntity(new CarServiceCore(2, 1, 5000.00, LocalDate.of(2022, 12, 12) ));
//      carServiceService.createEntity(new CarServiceCore(3, 2, 5000.00, LocalDate.of(2022, 12, 15)));

//      System.out.println(carServiceService.getEntityById(1));
//      System.out.println(carServiceService.getEntityById(2));
//      System.out.println(carServiceService.getEntityById(11));

//      carServiceService.updateEntity(new CarServiceCore(10, 1, 4000.00,  LocalDate.of(2022, 12, 15)), 11);
//      carServiceService.updateEntity(new CarServiceCore(10, 1, 4000.00,  LocalDate.of(2022, 12, 15)), 12);

//      carServiceService.removeEntityById(11);
//      carServiceService.removeEntityById(12);
    }
}