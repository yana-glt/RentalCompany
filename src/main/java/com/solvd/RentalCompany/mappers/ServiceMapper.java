package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.ServiceCore;
import com.solvd.RentalCompany.models.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiceMapper implements IServiceMapper{
    private final static Logger logger = LogManager.getLogger(ServiceMapper.class);
    @Override
    public ServiceCore modelToCore(Service service) {
        ServiceCore serviceCore = new ServiceCore();
        serviceCore.setId(service.getId());
        serviceCore.setName(service.getName());
        serviceCore.setAddress(service.getAddress());
        serviceCore.setPhone(service.getPhone());
        serviceCore.setCountry(service.getCountry());
        logger.info("Object of type Service has been successfully mapped to ServiceCore type.");
        return serviceCore;
    }

    @Override
    public Service coreToModel(ServiceCore serviceCore) {
        Service service = new Service();
        service.setId(serviceCore.getId());
        service.setName(serviceCore.getName());
        service.setAddress(serviceCore.getAddress());
        service.setPhone(serviceCore.getPhone());
        service.setCountry(serviceCore.getCountry());
        logger.info("Object of type ServiceCore has been successfully mapped to Service type.");
        return service;
    }
}
