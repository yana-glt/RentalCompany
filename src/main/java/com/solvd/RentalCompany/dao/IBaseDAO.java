package com.solvd.RentalCompany.dao;

import java.util.Optional;

public interface IBaseDAO <T, I>{
    T createEntity(T entity);

    Optional<T> getEntityById(I id);

    Optional<T> updateEntity(T entity, I id);

    void removeEntityById(I id);
}