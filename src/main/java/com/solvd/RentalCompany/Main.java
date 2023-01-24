package com.solvd.RentalCompany;

import com.solvd.RentalCompany.core.*;
import com.solvd.RentalCompany.services.*;

import java.time.LocalDate;
import java.time.Year;

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

        ICarServiceS carServiceS = new CarServiceS();
//      carServiceS.createEntity(new CarCore("KLX5484789DFCDV", "A", "Fiat", "500", "PL89564", Year.of(2020), 120.00));
//      carServiceS.createEntity(new CarCore("KJO894515SDCS48", "B", "Ford", "Fiesta", "PL00265",Year.of(2020), 140.00));

//      System.out.println(carServiceS.getEntityById(1));
//      System.out.println(carServiceS.getEntityById(2));
//      System.out.println(carServiceS.getEntityById(11));

//        carServiceS.updateEntity(new CarCore("00000000", "A",
//                "Fiat", "500", "PL89564", Year.of(2020), 120.00), 16);
//        carServiceS.updateEntity(new CarCore("000000", "A",
//                "Fiat", "500", "PL89564", Year.of(2020), 120.00), 17);

//        carServiceS.removeEntityById(16);
//        carServiceS.removeEntityById(17);

        ICategoryService categoryService = new CategoryService();
//      categoryService.createEntity(new CategoryCore("Y", "YYYY", "sjdcnjskdcn kjs", 2.33));
//      categoryService.createEntity(new CategoryCore("W", "WWWW", "+kjsxnjskxnsjkxn", 3.33));

//      System.out.println(categoryService.getEntityById("A"));
//      System.out.println(categoryService.getEntityById("Y"));

//      categoryService.updateEntity(new CategoryCore("Y", "OOOO", "sjdcnjskdcn kjs", 2.33), "Y");
//      categoryService.updateEntity(new CategoryCore("W", "OOOO", "+kjsxnjskxnsjkxn", 3.33), "W");

//      categoryService.removeEntityById("Y");
//      categoryService.removeEntityById( "W");

        IInsuranceTypeService insuranceTypeService = new InsuranceTypeService();
//      insuranceTypeService.createEntity(new InsuranceTypeCore("B", 40.00, 8.00));
//      insuranceTypeService.createEntity(new InsuranceTypeCore("D", 30.00, 6.00));

//      System.out.println(insuranceTypeService.getEntityById(1));
//      System.out.println(insuranceTypeService.getEntityById(2));
//      System.out.println(insuranceTypeService.getEntityById(11));

//      insuranceTypeService.updateEntity(new InsuranceTypeCore("A", 40.00, 8.00), 10);
//      insuranceTypeService.updateEntity(new InsuranceTypeCore("A", 30.00, 6.00), 11);

//      insuranceTypeService.removeEntityById(10);
//      insuranceTypeService.removeEntityById(11);
    }
}