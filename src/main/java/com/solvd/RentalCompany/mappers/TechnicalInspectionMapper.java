package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.TechnicalInspectionCore;
import com.solvd.RentalCompany.mappers.mapperInterfaces.ITechnicalInspectionMapper;
import com.solvd.RentalCompany.models.TechnicalInspection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TechnicalInspectionMapper implements ITechnicalInspectionMapper {

    private final static Logger logger = LogManager.getLogger(TechnicalInspectionMapper.class);
    @Override
    public TechnicalInspectionCore modelToCore(TechnicalInspection technicalInspection) {
        TechnicalInspectionCore technicalInspectionCore = new TechnicalInspectionCore();
        technicalInspectionCore.setId(technicalInspection.getId());
        technicalInspectionCore.setCarId(technicalInspection.getCarId());
        technicalInspectionCore.setDate(technicalInspection.getDate());
        technicalInspectionCore.setOrganization(technicalInspection.getOrganization());
        logger.info("Object of type TechnicalInspection has been successfully mapped to TechnicalInspectionCore type.");
        return technicalInspectionCore;
    }

    @Override
    public TechnicalInspection coreToModel(TechnicalInspectionCore technicalInspectionCore) {
        TechnicalInspection technicalInspection = new TechnicalInspection();
        technicalInspection.setId(technicalInspectionCore.getId());
        technicalInspection.setCarId(technicalInspectionCore.getCarId());
        technicalInspection.setDate(technicalInspectionCore.getDate());
        technicalInspection.setOrganization(technicalInspectionCore.getOrganization());
        logger.info("Object of type TechnicalInspectionCore has been successfully mapped to TechnicalInspection type.");
        return technicalInspection;
    }
}