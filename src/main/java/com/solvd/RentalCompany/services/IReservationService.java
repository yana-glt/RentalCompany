package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.*;

import java.time.LocalDate;

public interface IReservationService extends IBaseService<ReservationCore, Integer>{
    ReservationCore createEntity(ClientCore clientCore, CarCore carCore, EmployeeCore employeeCore, InsuranceTypeCore insuranceTypeCore, LocalDate df, LocalDate dt);
    ReservationCore createEntity(ClientCore clientCore, CarCore carCore, EmployeeCore employeeCore, InsuranceTypeCore insuranceTypeCore, LocalDate dt);
    ReservationCore createEntity(ClientCore clientCore, CarCore carCore, EmployeeCore employeeCore, InsuranceTypeCore insuranceTypeCore);
}