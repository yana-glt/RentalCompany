package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.ServiceCore;
import com.solvd.RentalCompany.exception_handlers.ObjectNotFoundException;

public interface IServiceService {
    ServiceCore createEntity(ServiceCore serviceCore);

    ServiceCore getEntityById(Integer id) throws ObjectNotFoundException;

    ServiceCore updateEntity(ServiceCore serviceCore, Integer id) throws ObjectNotFoundException;

    String removeEntityById(Integer id);
}
