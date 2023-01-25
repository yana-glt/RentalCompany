package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.LocationCore;
import com.solvd.RentalCompany.mappers.mapperInterfaces.ILocationMapper;
import com.solvd.RentalCompany.models.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocationMapper implements ILocationMapper {
    private final static Logger logger = LogManager.getLogger(LocationMapper.class);
    @Override
    public LocationCore modelToCore(Location location) {
        LocationCore locationCore = new LocationCore();
        locationCore.setId(location.getId());
        locationCore.setName(location.getName());
        locationCore.setPhone(location.getPhone());
        locationCore.setAddress(location.getAddress());
        locationCore.setCountry(location.getCountry());
        logger.info("Object of type Location has been successfully mapped to LocationCore type.");
        return locationCore;
    }

    @Override
    public Location coreToModel(LocationCore locationCore) {
        Location location = new Location();
        location.setId(locationCore.getId());
        location.setName(locationCore.getName());
        location.setAddress(locationCore.getAddress());
        location.setPhone(locationCore.getPhone());
        location.setCountry(locationCore.getCountry());
        logger.info("Object of type LocationCore has been successfully mapped to Location type.");
        return location;
    }
}