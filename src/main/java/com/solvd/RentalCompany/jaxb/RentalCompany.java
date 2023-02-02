package com.solvd.RentalCompany.jaxb;

import com.solvd.RentalCompany.models.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name="rental_company")
@XmlAccessorType(XmlAccessType.FIELD)
public class RentalCompany {
    @XmlElementWrapper(name="services")
    @XmlElement(name="service")
    private ArrayList<Service> services = new ArrayList<>();
    @XmlElementWrapper(name="car_services")
    @XmlElement(name="car_service")
    private ArrayList<CarService> carServices = new ArrayList<>();
    @XmlElementWrapper(name="cars")
    @XmlElement(name="car")
    private ArrayList<Car> cars = new ArrayList<>();
    @XmlElementWrapper(name="categories")
    @XmlElement(name="category")
    private ArrayList<Category> categories = new ArrayList<>();
    @XmlElementWrapper(name="technical_inspections")
    @XmlElement(name="technical_inspection")
    private ArrayList<TechnicalInspection> technicalInspections = new ArrayList<>();

    public RentalCompany() {
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    public void setCarServices(ArrayList<CarService> carServices) {
        this.carServices = carServices;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void setTechnicalInspections(ArrayList<TechnicalInspection> technicalInspections) {
        this.technicalInspections = technicalInspections;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public ArrayList<CarService> getCarServices() {
        return carServices;
    }
    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<TechnicalInspection> getTechnicalInspections() {
        return technicalInspections;
    }

    public boolean addService(Service service){
        return services.add(service);
    }

    public boolean addCarService(CarService carService){
        return carServices.add(carService);
    }

    public boolean addCar(Car car){
        return cars.add(car);
    }

    public boolean addCategory(Category category){
        return categories.add(category);
    }

    public boolean addTechnicalInspection(TechnicalInspection technicalInspection){
        return technicalInspections.add(technicalInspection);
    }


    @Override
    public String toString() {
        return "RentalCompany{" +
                "services=" + services +
                ", carServices=" + carServices +
                ", cars=" + cars +
                ", categories=" + categories +
                ", technicalInspections=" + technicalInspections +
                '}';
    }
}