package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.CarServiceCore;
import com.solvd.RentalCompany.dao.CarServiceDAO;
import com.solvd.RentalCompany.dao.ICarServiceDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.CarServiceMapper;
import com.solvd.RentalCompany.mappers.ICarServiceMapper;
import com.solvd.RentalCompany.models.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class CarServiceService implements ICarServiceService{
    private final static Logger logger = LogManager.getLogger(CarServiceService.class);
    private final ICarServiceDAO carServiceDAO = new CarServiceDAO();
    private final ICarServiceMapper carServiceMapper = new CarServiceMapper();

    @Override
    public CarServiceCore createEntity(CarServiceCore carServiceCore) {
        CarService carService = carServiceMapper.coreToModel(carServiceCore);
        CarService savedCarService = this.carServiceDAO.createEntity(carService);
        logger.info("Object of class CarService has been successfully created.");
        return carServiceCore;
    }

    @Override
    public CarServiceCore getEntityById(Integer id) {
        Optional<CarService> carServiceOptional = this.carServiceDAO.getEntityById(id);
        try{
            if(carServiceOptional.isEmpty()){
                throw new ObjectNotFoundException("Object was not found!", id);
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class CarService with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        CarService carService = carServiceOptional.get();
        return carServiceMapper.modelToCore(carService);
    }

    @Override
    public CarServiceCore updateEntity(CarServiceCore carServiceCore, Integer id) {
        Optional<CarService> carServiceOptional = this.carServiceDAO.updateEntity(carServiceMapper.coreToModel(carServiceCore), id);
        try {
            if (carServiceOptional.isEmpty()) {
                throw new ObjectNotFoundException("Object was not found!", carServiceCore.getId());
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class CarService with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        logger.info("Object of class CarService has been successfully updated.");
        return carServiceMapper.modelToCore(carServiceOptional.get());
    }

    @Override
    public void removeEntityById(Integer id) {
        this.carServiceDAO.removeEntityById(id);
        logger.info("Object of class CarService has been successfully deleted.");
    }
}