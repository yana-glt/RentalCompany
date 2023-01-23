package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.CarServiceCore;
import com.solvd.RentalCompany.core.ServiceCore;

public interface ICarServiceService {
    CarServiceCore createEntity(CarServiceCore carServiceCore);

    CarServiceCore getEntityById(Integer id);

    CarServiceCore updateEntity(CarServiceCore carServiceCore, Integer id);

    void removeEntityById(Integer id);
}