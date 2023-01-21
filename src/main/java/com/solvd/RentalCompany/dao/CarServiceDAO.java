package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.CarService;

import java.util.Optional;

public class CarServiceDAO extends MySQLDAO implements ICarServiceDAO{
    @Override
    public Optional<CarService> getEntityById(Integer id) {
        return null;
    }

    @Override
    public Optional<CarService> updateEntity(CarService entity, Integer id) {
        return null;
    }

    @Override
    public CarService createEntity(CarService entity) {
        return null;
    }

    @Override
    public void removeEntityById(Integer id) {

    }
}
