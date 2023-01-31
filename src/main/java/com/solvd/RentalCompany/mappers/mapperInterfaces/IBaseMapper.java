package com.solvd.RentalCompany.mappers.mapperInterfaces;

public interface IBaseMapper <P, R>{

    P modelToCore(R entity);
    R coreToModel(P entity);
}
