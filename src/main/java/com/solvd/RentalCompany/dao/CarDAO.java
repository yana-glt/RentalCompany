package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.Car;

public class CarDAO extends MySQLDAO implements ICarDAO{
    @Override
    public Car getEntityById(int id) {
        return null;
    }

    @Override
    public void updateEntity(Car entity) {

    }

    @Override
    public Car createEntity(Car entity) {
        return null;
    }

    @Override
    public void removeEntity(int id) {

    }
}
