package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.CarCore;
import com.solvd.RentalCompany.models.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarMapper implements ICarMapper{
    private final static Logger logger = LogManager.getLogger(CarMapper.class);

    @Override
    public CarCore modelToCore(Car car) {
        CarCore carCore = new CarCore();
        carCore.setId(car.getId());
        carCore.setVin(car.getVin());
        carCore.setCategoryId(car.getCategoryId());
        carCore.setBrand(car.getBrand());
        carCore.setModel(car.getModel());
        carCore.setNumber(car.getNumber());
        carCore.setYear(car.getYear());
        carCore.setDayPrice(car.getDayPrice());
        logger.info("Object of type Car has been successfully mapped to CarCore type.");
        return carCore;
    }

    @Override
    public Car coreToModel(CarCore carCore) {
        Car car = new Car();
        car.setId(carCore.getId());
        car.setVin(carCore.getVin());
        car.setCategoryId(carCore.getCategoryId());
        car.setBrand(carCore.getBrand());
        car.setModel(carCore.getModel());
        car.setNumber(carCore.getNumber());
        car.setYear(carCore.getYear());
        car.setDayPrice(carCore.getDayPrice());
        logger.info("Object of type CarCore has been successfully mapped to Car type.");
        return car;
    }
}