package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.*;
import com.solvd.RentalCompany.dao.*;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.*;
import com.solvd.RentalCompany.mappers.mapperInterfaces.*;
import com.solvd.RentalCompany.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Optional;

public class ReservationService implements IReservationService{
    private final static Logger logger = LogManager.getLogger(ReservationService.class);

    private final IReservationDAO reservationDAO = new ReservationDAO();
    private final IClientDAO clientDAO = new ClientDAO();
    private final ICarDAO carDAO = new CarDAO();
    private final IEmployeeDAO employeeDAO = new EmployeeDAO();
    private final IInsuranceTypeDAO insuranceTypeDAO = new InsuranceTypeDAO();
    private final IReservationMapper reservationMapper = new ReservationMapper();
    private final IClientMapper clientMapper = new ClientMapper();
    private final ICarMapper carMapper = new CarMapper();
    private final IEmployeeMapper employeeMapper = new EmployeeMapper();
    private final IInsuranceTypeMapper insuranceTypeMapper = new InsuranceTypeMapper();
    @Override
    public ReservationCore createEntity(ReservationCore reservationCore) {
        Reservation reservation = reservationMapper.coreToModel(reservationCore);
        Reservation savedReservation = this.reservationDAO.createEntity(reservation);
        logger.info("Object of class Reservation has been successfully created.");
        return reservationCore;
    }
    public ReservationCore createEntity(Client client, Car car, Employee employee, InsuranceType insuranceType, LocalDate dateFrom, LocalDate dateTo) {
        Reservation reservation = new Reservation();
        reservation.setClientId(client.getId());
        reservation.setCarId(car.getId());
        reservation.setEmployeeId(employee.getId());
        reservation.setInsuranceId(insuranceType.getId());
        reservation.setFromDate(dateFrom);
        reservation.setToDate(dateTo);
        reservation.setPrice(0.00);
        Reservation savedReservation = this.reservationDAO.createEntity(reservation);
        logger.info("Object of class Reservation has been successfully created.");
        ReservationCore reservationCore = reservationMapper.modelToCore(reservation);
        return reservationCore;
    }
    public ReservationCore createEntity(Client client, Car car, Employee employee, InsuranceType insuranceType, LocalDate dateTo) {
        Reservation reservation = new Reservation();
        reservation.setClientId(client.getId());
        reservation.setCarId(car.getId());
        reservation.setEmployeeId(employee.getId());
        reservation.setInsuranceId(insuranceType.getId());
        reservation.setFromDate(LocalDate.now());
        reservation.setToDate(dateTo);
        reservation.setPrice(0.00);
        Reservation savedReservation = this.reservationDAO.createEntity(reservation);
        logger.info("Object of class Reservation has been successfully created.");
        ReservationCore reservationCore = reservationMapper.modelToCore(reservation);
        return reservationCore;
    }
    public ReservationCore createEntity(Client client, Car car, Employee employee, InsuranceType insuranceType) {
        Reservation reservation = new Reservation();
        reservation.setClientId(client.getId());
        reservation.setCarId(car.getId());
        reservation.setEmployeeId(employee.getId());
        reservation.setInsuranceId(insuranceType.getId());
        reservation.setFromDate(LocalDate.now());
        reservation.setToDate(null);
        reservation.setPrice(0.00);
        Reservation savedReservation = this.reservationDAO.createEntity(reservation);
        logger.info("Object of class Reservation has been successfully created.");
        ReservationCore reservationCore = reservationMapper.modelToCore(reservation);
        return reservationCore;
    }

    @Override
    public ReservationCore getEntityById(Integer id) {
        Optional<Reservation> reservationOptional = this.reservationDAO.getEntityById(id);
        try{
            if(reservationOptional.isEmpty()){
                throw new ObjectNotFoundException("Object was not found!", id);
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Reservation with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        Reservation reservation = reservationOptional.get();
        return reservationMapper.modelToCore(reservation);
    }

    @Override
    public ReservationCore updateEntity(ReservationCore reservationCore, Integer id) {
        Optional<Reservation> reservationOptional = this.reservationDAO.updateEntity(reservationMapper.coreToModel(reservationCore), id);
        try {
            if (reservationOptional.isEmpty()) {
                throw new ObjectNotFoundException("Object was not found!", reservationCore.getId());
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Reservation with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        logger.info("Object of class Reservation has been successfully updated.");
        return reservationMapper.modelToCore(reservationOptional.get());
    }

    @Override
    public void removeEntityById(Integer id) {
        this.reservationDAO.removeEntityById(id);
        logger.info("Object of class Reservation has been successfully deleted.");
    }
}