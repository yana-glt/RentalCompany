package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.TechnicalInspectionCore;
import com.solvd.RentalCompany.dao.ITechnicalInspectionDAO;
import com.solvd.RentalCompany.dao.TechnicalInspectionDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.ITechnicalInspectionMapper;
import com.solvd.RentalCompany.mappers.TechnicalInspectionMapper;
import com.solvd.RentalCompany.models.TechnicalInspection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class TechnicalInspectionService implements ITechnicalInspectionService{
    private final static Logger logger = LogManager.getLogger(TechnicalInspectionService.class);
    private final ITechnicalInspectionDAO technicalInspectionDAO = new TechnicalInspectionDAO();
    private final ITechnicalInspectionMapper technicalInspectionMapper = new TechnicalInspectionMapper();
    @Override
    public TechnicalInspectionCore createEntity(TechnicalInspectionCore technicalInspectionCore) {
        TechnicalInspection technicalInspection = technicalInspectionMapper.coreToModel(technicalInspectionCore);
        TechnicalInspection savedTechnicalInspection = this.technicalInspectionDAO.createEntity(technicalInspection);
        logger.info("Object of class TechnicalInspection has been successfully created.");
        return technicalInspectionCore;
    }

    @Override
    public TechnicalInspectionCore getEntityById(Integer id) {
        Optional<TechnicalInspection> technicalInspectionOptional = this.technicalInspectionDAO.getEntityById(id);
        try{
            if(technicalInspectionOptional.isEmpty()){
                throw new ObjectNotFoundException("Object was not found!", id);
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class TechnicalInspection with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        TechnicalInspection technicalInspection = technicalInspectionOptional.get();
        return technicalInspectionMapper.modelToCore(technicalInspection);
    }

    @Override
    public TechnicalInspectionCore updateEntity(TechnicalInspectionCore technicalInspectionCore, Integer id) {
        Optional<TechnicalInspection> technicalInspectionOptional = this.technicalInspectionDAO
                .updateEntity(technicalInspectionMapper.coreToModel(technicalInspectionCore), id);
        try {
            if (technicalInspectionOptional.isEmpty()) {
                throw new ObjectNotFoundException("Object was not found!", technicalInspectionCore.getId());
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Car with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        logger.info("Object of class TechnicalInspection has been successfully updated.");
        return technicalInspectionMapper.modelToCore(technicalInspectionOptional.get());
    }

    @Override
    public void removeEntityById(Integer id) {
        this.technicalInspectionDAO.removeEntityById(id);
        logger.info("Object of class TechnicalInspection has been successfully deleted.");
    }
}