package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.Car;

import java.util.Optional;

public class CarDAO extends MySQLDAO implements ICarDAO{
    @Override
    public Optional<Car> getEntityById(Integer id) {
        return null;
    }

    @Override
    public Optional<Car> updateEntity(Car entity, Integer id) {
        return null;
    }

    @Override
    public Car createEntity(Car entity) {
        return null;
    }

    @Override
    public void removeEntityById(Integer id) {

    }
}
