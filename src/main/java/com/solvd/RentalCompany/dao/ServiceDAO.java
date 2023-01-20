package com.solvd.RentalCompany.dao;

import com.solvd.RentalCompany.models.Service;

public class ServiceDAO extends MySQLDAO implements IServiceDAO{
    @Override
    public Service getEntityById(int id) {
        return null;
    }

    @Override
    public void updateEntity(Service entity) {

    }

    @Override
    public Service createEntity(Service entity) {
        return null;
    }

    @Override
    public void removeEntity(int id) {

    }
}
