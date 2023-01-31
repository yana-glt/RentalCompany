package com.solvd.RentalCompany.services;

public interface IBaseService <T, I>{
    T createEntity(T entity);

    T getEntityById(I id);

    T updateEntity(T entity, I id);

    void removeEntityById(I id);
}