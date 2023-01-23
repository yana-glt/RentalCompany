package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.CarServiceCore;
import com.solvd.RentalCompany.models.CarService;

public interface ICarServiceMapper {

    CarServiceCore modelToCore(CarService carService);
    CarService coreToModel(CarServiceCore carServiceCore);
}