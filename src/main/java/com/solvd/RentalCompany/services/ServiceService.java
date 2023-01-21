package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.ServiceCore;
import com.solvd.RentalCompany.dao.IServiceDAO;
import com.solvd.RentalCompany.dao.ServiceDAO;
import com.solvd.RentalCompany.exception_handlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.IServiceMapper;
import com.solvd.RentalCompany.mappers.ServiceMapper;
import com.solvd.RentalCompany.models.Service;

import java.util.Optional;

public class ServiceService implements IServiceService{
    private final IServiceDAO serviceDAO = new ServiceDAO();
    private final IServiceMapper serviceMapper = new ServiceMapper();

    @Override
    public ServiceCore createEntity(ServiceCore serviceCore) {
        Service service = serviceMapper.coreToModel(serviceCore);
        Service savedService = this.serviceDAO.createEntity(service);
        return serviceCore;
    }

    @Override
    public ServiceCore getEntityById(Integer id) throws ObjectNotFoundException {
        Optional<Service> serviceOptional = this.serviceDAO.getEntityById(id);
        if(serviceOptional.isEmpty()){
            throw new ObjectNotFoundException("Object was not found!", id);
        }
        Service service = serviceOptional.get();
        return serviceMapper.modelToCore(service);
    }

    @Override
    public ServiceCore updateEntity(ServiceCore serviceCore, Integer id) throws ObjectNotFoundException {
        Optional<Service>optionalService = this.serviceDAO.updateEntity(serviceMapper.coreToModel(serviceCore), id);
        if(optionalService.isEmpty()){
            throw new ObjectNotFoundException("Object was not found!", serviceCore.getId());
        }
        return serviceMapper.modelToCore(optionalService.get());
    }

    @Override
    public String removeEntityById(Integer id) {
        this.serviceDAO.removeEntityById(id);
        return "Service has been deleted successfully!";
    }
}
