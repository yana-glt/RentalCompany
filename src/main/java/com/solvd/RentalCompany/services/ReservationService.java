package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.ReservationCore;
import com.solvd.RentalCompany.dao.IReservationDAO;
import com.solvd.RentalCompany.dao.ReservationDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.mapperInterfaces.IReservationMapper;
import com.solvd.RentalCompany.mappers.ReservationMapper;
import com.solvd.RentalCompany.models.Reservation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class ReservationService implements IReservationService{
    private final static Logger logger = LogManager.getLogger(ReservationService.class);
    private final IReservationDAO reservationDAO = new ReservationDAO();
    private final IReservationMapper reservationMapper = new ReservationMapper();
    @Override
    public ReservationCore createEntity(ReservationCore reservationCore) {
        Reservation reservation = reservationMapper.coreToModel(reservationCore);
        Reservation savedReservation = this.reservationDAO.createEntity(reservation);
        logger.info("Object of class Reservation has been successfully created.");
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