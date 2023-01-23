package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.ServiceCore;
import com.solvd.RentalCompany.models.Service;

public interface IServiceMapper {
    ServiceCore modelToCore(Service service);
    Service coreToModel(ServiceCore serviceCore);
}