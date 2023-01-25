package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.LocationCore;
import com.solvd.RentalCompany.dao.ILocationDAO;
import com.solvd.RentalCompany.dao.LocationDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.mapperInterfaces.ILocationMapper;
import com.solvd.RentalCompany.mappers.LocationMapper;
import com.solvd.RentalCompany.models.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class LocationService implements ILocationService{
    private final static Logger logger = LogManager.getLogger(LocationService.class);
    private final ILocationDAO locationDAO = new LocationDAO();
    private final ILocationMapper locationMapper = new LocationMapper();
    @Override
    public LocationCore createEntity(LocationCore locationCore) {
        Location location = locationMapper.coreToModel(locationCore);
        Location savedLocation = this.locationDAO.createEntity(location);
        logger.info("Object of class Location has been successfully created.");
        return locationCore;
    }

    @Override
    public LocationCore getEntityById(Integer id) {
        Optional<Location> locationOptional = this.locationDAO.getEntityById(id);
        try{
            if(locationOptional.isEmpty()){
                throw new ObjectNotFoundException("Object was not found!", id);
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Location with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        Location location = locationOptional.get();
        return locationMapper.modelToCore(location);
    }

    @Override
    public LocationCore updateEntity(LocationCore locationCore, Integer id) {
        Optional<Location> locationOptional = this.locationDAO.updateEntity(locationMapper.coreToModel(locationCore), id);
        try {
            if (locationOptional.isEmpty()) {
                throw new ObjectNotFoundException("Object was not found!", locationCore.getId());
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Location with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        logger.info("Object of class Location has been successfully updated.");
        return locationMapper.modelToCore(locationOptional.get());
    }

    @Override
    public void removeEntityById(Integer id) {
        this.locationDAO.removeEntityById(id);
        logger.info("Object of class Location has been successfully deleted.");
    }
}