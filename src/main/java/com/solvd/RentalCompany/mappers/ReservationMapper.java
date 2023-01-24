package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.ReservationCore;
import com.solvd.RentalCompany.models.Reservation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReservationMapper implements IReservationMapper {
    private final static Logger logger = LogManager.getLogger(ReservationMapper.class);
    @Override
    public ReservationCore modelToCore(Reservation reservation) {
        ReservationCore reservationCore = new ReservationCore();
        reservationCore.setId(reservation.getId());
        reservationCore.setClientId(reservation.getClientId());
        reservationCore.setEmployeeId(reservation.getEmployeeId());
        reservationCore.setCarId(reservation.getCarId());
        reservationCore.setInsuranceId(reservation.getInsuranceId());
        reservationCore.setFromDate(reservation.getFromDate());
        reservationCore.setToDate(reservation.getToDate());
        reservationCore.setPrice(reservation.getPrice());
        logger.info("Object of type Reservation has been successfully mapped to ReservationCore type.");
        return reservationCore;
    }

    @Override
    public Reservation coreToModel(ReservationCore reservationCore) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationCore.getId());
        reservation.setClientId(reservationCore.getClientId());
        reservation.setEmployeeId(reservationCore.getEmployeeId());
        reservation.setCarId(reservationCore.getCarId());
        reservation.setInsuranceId(reservationCore.getInsuranceId());
        reservation.setFromDate(reservationCore.getFromDate());
        reservation.setToDate(reservationCore.getToDate());
        reservation.setPrice(reservationCore.getPrice());
        logger.info("Object of type ReservationCore has been successfully mapped to Reservation type.");
        return reservation;
    }
}