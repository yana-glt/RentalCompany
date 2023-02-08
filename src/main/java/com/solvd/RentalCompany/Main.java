package com.solvd.RentalCompany;

import com.solvd.RentalCompany.core.CarCore;
import com.solvd.RentalCompany.models.*;
import com.solvd.RentalCompany.services.*;
import com.solvd.RentalCompany.services.mybatisImplementation.CarServiceImpl;

import java.io.IOException;
import java.time.Year;

public class Main {
    public static void main(String[] args) throws IOException {
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
//      carServiceService.createEntity(new CarServiceCore(2, 1, 5000.00, LocalDate.of(2022, 12, 12)));
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

        ITechnicalInspectionService technicalInspectionService = new TechnicalInspectionService();
//      technicalInspectionService.createEntity(new TechnicalInspectionCore(1, LocalDate.of(2022, 12, 12), "OOO"));
//      technicalInspectionService.createEntity(new TechnicalInspectionCore(2, LocalDate.of(2022, 12, 15), "OOO"));

//      System.out.println(technicalInspectionService.getEntityById(1));
//      System.out.println(technicalInspectionService.getEntityById(2));
//      System.out.println(technicalInspectionService.getEntityById(11));

//      technicalInspectionService.updateEntity(new TechnicalInspectionCore(10, LocalDate.of(2022, 12, 12), "OOO"), 10);
//      technicalInspectionService.updateEntity(new TechnicalInspectionCore(10, LocalDate.of(2022, 12, 15), "OOO"), 11);

//      technicalInspectionService.removeEntityById(11);
//      technicalInspectionService.removeEntityById(10);

        IDepartmentService departmentService = new DepartmentService();
//      departmentService.createEntity(new DepartmentCore("IT", 10000.00, 20000.00));
//      departmentService.createEntity(new DepartmentCore("IT", 5000.00, 10000.00));

//      System.out.println(departmentService.getEntityById(1));
//      System.out.println(departmentService.getEntityById(2));
//      System.out.println(departmentService.getEntityById(7));

//      departmentService.updateEntity(new DepartmentCore("OOO", 10000.00, 20000.00), 8);
//      departmentService.updateEntity(new DepartmentCore("OOO", 10000.00, 20000.00), 9);

//      departmentService.removeEntityById(8);
//      departmentService.removeEntityById(9);

        ILocationService locationService = new LocationService();
//      locationService.createEntity(new LocationCore("FFF", "+48962620520", "jkxfvnjkvn", "USA"));
//      locationService.createEntity(new LocationCore("DDD", "+48962620520", "mnkldfvnjdk", "USA"));

//      System.out.println(locationService.getEntityById(1));
//      System.out.println(locationService.getEntityById(2));
//      System.out.println(locationService.getEntityById(6));

//      locationService.updateEntity(new LocationCore("FFF", "+48962620520", "jkxfvnjkvn", "USA"), 5);
//      locationService.updateEntity(new LocationCore("FFF", "+48962620520", "jkxfvnjkvn", "USA"), 6);

//      locationService.removeEntityById(5);
//      locationService.removeEntityById(6);

        IEmployeeService employeeService = new EmployeeService();
//      employeeService.createEntity(new EmployeeCore("Bob", "Dilan", "bob@gmail.com", "+48526962514", 2000.00, 1, 1));
//      employeeService.createEntity(new EmployeeCore("Bob", "Dilan", "bob@gmail.com", "+48526962514", 2000.00, 1, 1));

//      System.out.println(employeeService.getEntityById(1));
//      System.out.println(employeeService.getEntityById(2));
//      System.out.println(employeeService.getEntityById(14));

//      employeeService.updateEntity(new EmployeeCore("Li", "Dilan", "li@gmail.com", "+48526962514", 2500.00, 1, 1), 14);
//      employeeService.updateEntity(new EmployeeCore("Rob", "Dilan", "rob@gmail.com", "+48526962514", 1500.00, 1, 1), 15);

//      employeeService.removeEntityById(15);
//      employeeService.removeEntityById(14);

        IClientService clientService = new ClientService();
//      clientService.createEntity(new ClientCore("Bob", "Dilan", "bob@gmail.com", "+48526962514"));
//      clientService.createEntity(new ClientCore("Bob", "Dilan", "bob@gmail.com", "+48526962514"));

//      System.out.println(clientService.getEntityById(1));
//      System.out.println(clientService.getEntityById(2));
//      System.out.println(clientService.getEntityById(10));

//      clientService.updateEntity(new ClientCore("Rob", "Dilan", "bob@gmail.com", "+48526962514"), 10);
//      clientService.updateEntity(new ClientCore("Rob", "Dilan", "bob@gmail.com", "+48526962514"), 11);

//      clientService.removeEntityById(10);
//      clientService.removeEntityById(11);

        ILicenseService licenseService = new LicenseService();
//      licenseService.createEntity(new LicenseCore(1, "9564884651", LocalDate.of(2020, 12, 15), LocalDate.of(2030, 12, 12), true));
//      licenseService.createEntity(new LicenseCore(2, "8946541548", LocalDate.of(2021, 12, 15), LocalDate.of(2031, 12, 15), true));

//      System.out.println(licenseService.getEntityById(1));
//      System.out.println(licenseService.getEntityById(2));
//      System.out.println(licenseService.getEntityById(10));

//      licenseService.updateEntity(new LicenseCore(1, "000", LocalDate.of(2020, 12, 15), LocalDate.of(2030, 12, 12), true), 10);
//      licenseService.updateEntity(new LicenseCore(1, "000", LocalDate.of(2020, 12, 15), LocalDate.of(2030, 12, 12), true), 11);

//      licenseService.removeEntityById(11);
//      licenseService.removeEntityById(10);

        IReservationService reservationService = new ReservationService();
//      reservationService.createEntity(new ReservationCore(1, 2, 3, 1, LocalDate.of(2022, 12, 12), LocalDate.of(2022, 12, 14), 500.00));
//      reservationService.createEntity(new ReservationCore(2, 1, 4, 2,LocalDate.of(2022, 12, 10), LocalDate.of(2022, 12, 12), 300.00));

//      System.out.println(reservationService.getEntityById(1));
//      System.out.println(reservationService.getEntityById(2));
//      System.out.println(reservationService.getEntityById(12));

//      reservationService.updateEntity(new ReservationCore(2, 2, 3, 1, LocalDate.of(2022, 12, 12), LocalDate.of(2022, 12, 14), 500.00), 12);
//      reservationService.updateEntity(new ReservationCore(2, 2, 3, 1, LocalDate.of(2022, 12, 12), LocalDate.of(2022, 12, 14), 500.00), 13);

//      reservationService.removeEntityById(24);
//      reservationService.removeEntityById(29);

//        reservationService.createEntity(
//                new ClientCore(33, "Bruce", "Ernst", "bruceernst@gmail.com", "+48962512321"),
//                new CarCore(5, "XLM8592KM00152L56", "A", "Kia", "Picanto", "RJA4198", Year.of(2020), 100.00),
//                new EmployeeCore(5, "Tara", "Shelton", "taraShelton@gmail.com", "+48603203210", 900.00, 1, 1),
//                new InsuranceTypeCore(33, "A", 30.00, 6.00),
//                LocalDate.of(2022, 12, 14),
//                LocalDate.of(2022, 12, 15));


//        reservationService.createEntity(new ReservationCore(
//                new Client(1, "Bruce", "Ernst", "bruceernst@gmail.com", "+48962512321"),
//                new Car(1, "XLM8592KM00152L56", "A", "Kia", "Picanto", "RJA4198", Year.of(2020), 100.00),
//                new Employee(1, "Tara", "Shelton", "taraShelton@gmail.com", "+48603203210", 900.00, 1, 1),
//                new InsuranceType(1, "A", 30.00, 6.00),
//                LocalDate.now()));

//        boolean result = DomParser.validateXmlSchema("rentalCompany.xsd", "rentalCompany.xml");
//        System.out.println("rentalCompany.xml validates again rentalCompany.xse? " + result);
//        DomParser.parse();

        //JaxbWriter.write();
//        RentalCompany rc = JaxbReader.read();
//        System.out.println(rc.getCars().get(2).getYear());

//        RentalCompany rentalCompany = new RentalCompany() {
//            {
//                Service service = new Service(4,"WAT service","Warsaw","+48745468787","Poland");
//                this.addService(service);
//                service = new Service(5,"FAT service","Warsaw","+48520520630","Poland");
//                this.addService(service);
//                service = new Service(6,"RAT service","Warsaw","+48501548748","Poland");
//                this.addService(service);
//
//                CarService carService = new CarService(4,1, 4,1000.00, LocalDate.of(2022,11,05));
//                this.addCarService(carService);
//                carService = new CarService(5,2,5,2000.00, LocalDate.of(2022, 10, 10));
//                this.addCarService(carService);
//                carService = new CarService(6,3,6,3000.00, LocalDate.of(2022, 12, 15));
//                this.addCarService(carService);
//
//                Car car = new Car(1, "XLM8592KM00152L56", "A", "Kia", "Picanto", "RJA4198", Year.of(2020), 100.00);
//                this.addCar(car);
//                car = new Car(2, "PKT001KW945444878", "A", "Fiat", "500", "PLO7003", Year.of(2019), 115.00);
//                this.addCar(car);
//                car = new Car(3, "LTY9003HY8521P961", "B", "VolksWagen", "Polo", "PLO7003", Year.of(2019), 130.00);
//                this.addCar(car);
//
//                Category category = new Category("A", "mini cars", "Smaller than 370 cm in length.",1.20);
//                this.addCategory(category);
//                category = new Category("B", "small cars","Sizes range from 370 cm to 400 cm. ", 1.30);
//                this.addCategory(category);
//
//                TechnicalInspection technicalInspection = new TechnicalInspection(1,1, LocalDate.of(2022,11,05), "SGS Poland Sp. z o.o.");
//                this.addTechnicalInspection(technicalInspection);
//                technicalInspection = new TechnicalInspection(2,2, LocalDate.of(2022, 10, 10), "SGS Poland Sp. z o.o.");
//                this.addTechnicalInspection(technicalInspection);
//                technicalInspection = new TechnicalInspection(3,3, LocalDate.of(2022, 12, 15), "SGS Poland Sp. z o.o.");
//                this.addTechnicalInspection(technicalInspection);
//            }
//        };
//
//        JsonWriterReader.writeToJson(rentalCompany);
//
//        RentalCompany rentComp = new RentalCompany();
//        rentComp = JsonWriterReader.readFromJson("src/main/java/com/solvd/RentalCompany/jackson/company.json", RentalCompany.class);
//        System.out.println(rentComp.getCars().get(0).getModel());

        ICarServiceS carServiceImpl = new CarServiceImpl();
//        System.out.println(carServiceImpl.getEntityById(3));
//        System.out.println(carServiceImpl.getEntityById(4));
//
//        carServiceImpl.removeEntityById(10);

//        carServiceImpl.createEntity(new CarCore("KLX5484789DFCDV", "A", "Fiat", "500", "PL89564", Year.of(2020), 120.00));
//        carServiceImpl.createEntity(new CarCore("KJO894515SDCS48", "B", "Ford", "Fiesta", "PL00265",Year.of(2020), 140.00));

        carServiceImpl.updateEntity(new CarCore("00000000", "A",
                "Fiat", "500", "PL89564", Year.of(2020), 120.00), 11);
        carServiceImpl.updateEntity(new CarCore("000000", "A",
                "Fiat", "500", "PL89564", Year.of(2020), 120.00), 12);
    }
}