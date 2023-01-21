package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.ServiceCore;
import com.solvd.RentalCompany.models.Service;

public class ServiceMapper implements IServiceMapper{
    @Override
    public ServiceCore modelToCore(Service service) {
        ServiceCore serviceCore = new ServiceCore();
        serviceCore.setId(service.getId());
        serviceCore.setName(service.getName());
        serviceCore.setAddress(service.getAddress());
        serviceCore.setPhone(service.getPhone());
        serviceCore.setCountry(service.getCountry());
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
        return service;
    }
}
