package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.CarServiceCore;
import com.solvd.RentalCompany.models.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarServiceMapper implements ICarServiceMapper{
    private final static Logger logger = LogManager.getLogger(CarServiceMapper.class);

    @Override
    public CarServiceCore modelToCore(CarService carService) {
        CarServiceCore carServiceCore = new CarServiceCore();
        carServiceCore.setId(carService.getId());
        carServiceCore.setCarId(carService.getCarId());
        carServiceCore.setServiceId(carService.getServiceId());
        carServiceCore.setPrice(carService.getPrice());
        carServiceCore.setDate(carService.getDate());
        logger.info("Object of type CarService has been successfully mapped to CarServiceCore type.");
        return carServiceCore;
    }

    @Override
    public CarService coreToModel(CarServiceCore carServiceCore) {
        CarService carService = new CarService();
        carService.setId(carServiceCore.getId());
        carService.setCarId(carServiceCore.getCarId());
        carService.setServiceId(carServiceCore.getServiceId());
        carService.setPrice(carServiceCore.getPrice());
        carService.setDate(carServiceCore.getDate());
        logger.info("Object of type CarServiceCore has been successfully mapped to CarService type.");
        return carService;
    }
}