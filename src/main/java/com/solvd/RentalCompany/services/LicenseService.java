package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.LicenseCore;
import com.solvd.RentalCompany.dao.ILicenseDAO;
import com.solvd.RentalCompany.dao.LicenseDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.mapperInterfaces.ILicenseMapper;
import com.solvd.RentalCompany.mappers.LicenseMapper;
import com.solvd.RentalCompany.models.License;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class LicenseService implements ILicenseService{
    private final static Logger logger = LogManager.getLogger(LicenseService.class);
    private final ILicenseDAO licenseDAO = new LicenseDAO();
    private final ILicenseMapper licenseMapper = new LicenseMapper();
    @Override
    public LicenseCore createEntity(LicenseCore licenseCore) {
        License license = licenseMapper.coreToModel(licenseCore);
        License savedLicense = this.licenseDAO.createEntity(license);
        logger.info("Object of class License has been successfully created.");
        return licenseCore;
    }

    @Override
    public LicenseCore getEntityById(Integer id) {
        Optional<License> licenseOptional = this.licenseDAO.getEntityById(id);
        try{
            if(licenseOptional.isEmpty()){
                throw new ObjectNotFoundException("Object was not found!", id);
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class License with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        License license = licenseOptional.get();
        return licenseMapper.modelToCore(license);
    }

    @Override
    public LicenseCore updateEntity(LicenseCore licenseCore, Integer id) {
        Optional<License> licenseOptional = this.licenseDAO.updateEntity(licenseMapper.coreToModel(licenseCore), id);
        try {
            if (licenseOptional.isEmpty()) {
                throw new ObjectNotFoundException("Object was not found!", licenseCore.getId());
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class License with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        logger.info("Object of class License has been successfully updated.");
        return licenseMapper.modelToCore(licenseOptional.get());
    }

    @Override
    public void removeEntityById(Integer id) {
        this.licenseDAO.removeEntityById(id);
        logger.info("Object of class License has been successfully deleted.");
    }
}