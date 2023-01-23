package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.ServiceCore;
import com.solvd.RentalCompany.dao.IServiceDAO;
import com.solvd.RentalCompany.dao.ServiceDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.IServiceMapper;
import com.solvd.RentalCompany.mappers.ServiceMapper;
import com.solvd.RentalCompany.models.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ServiceService implements IServiceService{
    private final static Logger logger = LogManager.getLogger(ServiceService.class);
    private final IServiceDAO serviceDAO = new ServiceDAO();
    private final IServiceMapper serviceMapper = new ServiceMapper();

    @Override
    public ServiceCore createEntity(ServiceCore serviceCore) {
        Service service = serviceMapper.coreToModel(serviceCore);
        Service savedService = this.serviceDAO.createEntity(service);
        logger.info("Object of class Service has been successfully created.");
        return serviceCore;
    }

    @Override
    public ServiceCore getEntityById(Integer id){
        Optional<Service> serviceOptional = this.serviceDAO.getEntityById(id);
        try{
            if(serviceOptional.isEmpty()){
                throw new ObjectNotFoundException("Object was not found!", id);
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Service with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        Service service = serviceOptional.get();
        return serviceMapper.modelToCore(service);
    }

    @Override
    public ServiceCore updateEntity(ServiceCore serviceCore, Integer id){
        Optional<Service> serviceOptional = this.serviceDAO.updateEntity(serviceMapper.coreToModel(serviceCore), id);
        try {
            if (serviceOptional.isEmpty()) {
                throw new ObjectNotFoundException("Object was not found!", serviceCore.getId());
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Service with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        logger.error("Object of class Service has been successfully updated.");
        return serviceMapper.modelToCore(serviceOptional.get());
    }

    @Override
    public void removeEntityById(Integer id) {
        this.serviceDAO.removeEntityById(id);
        logger.info("Object of class Service has been successfully deleted.");
    }
}