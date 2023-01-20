package com.solvd.RentalCompany.dao;

public interface IBaseDAO <T>{
    T getEntityById(int id);
    void updateEntity(T entity);
    T createEntity(T entity);
    void removeEntity(int id);
}
