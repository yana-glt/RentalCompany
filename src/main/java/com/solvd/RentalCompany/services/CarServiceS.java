package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.CarCore;
import com.solvd.RentalCompany.dao.CarDAO;
import com.solvd.RentalCompany.dao.ICarDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.CarMapper;
import com.solvd.RentalCompany.mappers.mapperInterfaces.ICarMapper;
import com.solvd.RentalCompany.models.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class CarServiceS implements ICarServiceS{
    private final static Logger logger = LogManager.getLogger(CarServiceS.class);
    private final ICarDAO carDAO = new CarDAO();
    private final ICarMapper carMapper = new CarMapper();
    @Override
    public CarCore createEntity(CarCore carCore) {
        Car car = carMapper.coreToModel(carCore);
        Car savedCar = this.carDAO.createEntity(car);
        logger.info("Object of class Car has been successfully created.");
        return carCore;
    }

    @Override
    public CarCore getEntityById(Integer id) {
        Optional<Car> carOptional = this.carDAO.getEntityById(id);
        try{
            if(carOptional.isEmpty()){
                throw new ObjectNotFoundException("Object was not found!", id);
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Car with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        Car car = carOptional.get();
        return carMapper.modelToCore(car);
    }

    @Override
    public CarCore updateEntity(CarCore carCore, Integer id) {
        Optional<Car> carOptional = this.carDAO.updateEntity(carMapper.coreToModel(carCore), id);
        try {
            if (carOptional.isEmpty()) {
                throw new ObjectNotFoundException("Object was not found!", carCore.getId());
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Car with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        logger.info("Object of class Car has been successfully updated.");
        return carMapper.modelToCore(carOptional.get());
    }

    @Override
    public void removeEntityById(Integer id) {
            this.carDAO.removeEntityById(id);
            logger.info("Object of class Car has been successfully deleted.");
    }
}