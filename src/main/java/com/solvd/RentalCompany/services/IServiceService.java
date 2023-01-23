package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.ServiceCore;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;

public interface IServiceService {
    ServiceCore createEntity(ServiceCore serviceCore);

    ServiceCore getEntityById(Integer id);

    ServiceCore updateEntity(ServiceCore serviceCore, Integer id);

    void removeEntityById(Integer id);
}
