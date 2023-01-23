package com.solvd.RentalCompany.dao;

import java.util.Optional;

public interface IBaseDAO <T, IdType>{
    T createEntity(T entity);

    Optional<T> getEntityById(IdType id);

    Optional<T> updateEntity(T entity, IdType id);

    void removeEntityById(IdType id);
}