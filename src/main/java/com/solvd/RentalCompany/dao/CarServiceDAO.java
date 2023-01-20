package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.CarService;

public class CarServiceDAO extends MySQLDAO implements ICarServiceDAO{
    @Override
    public CarService getEntityById(int id) {
        return null;
    }

    @Override
    public void updateEntity(CarService entity) {

    }

    @Override
    public CarService createEntity(CarService entity) {
        return null;
    }

    @Override
    public void removeEntity(int id) {

    }
}
