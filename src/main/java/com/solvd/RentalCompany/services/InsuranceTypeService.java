package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.InsuranceTypeCore;
import com.solvd.RentalCompany.dao.IInsuranceTypeDAO;
import com.solvd.RentalCompany.dao.InsuranceTypeDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.IInsuranceTypeMapper;
import com.solvd.RentalCompany.mappers.InsuranceTypeMapper;
import com.solvd.RentalCompany.models.InsuranceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class InsuranceTypeService implements IInsuranceTypeService{
    private final static Logger logger = LogManager.getLogger(InsuranceTypeService.class);
    private final IInsuranceTypeDAO insuranceTypeDAO = new InsuranceTypeDAO();
    private final IInsuranceTypeMapper insuranceTypeMapper = new InsuranceTypeMapper();
    @Override
    public InsuranceTypeCore createEntity(InsuranceTypeCore insuranceTypeCore) {
        InsuranceType insuranceType = insuranceTypeMapper.coreToModel(insuranceTypeCore);
        InsuranceType savedInsuranceType = this.insuranceTypeDAO.createEntity(insuranceType);
        logger.info("Object of class InsuranceType has been successfully created.");
        return insuranceTypeCore;
    }

    @Override
    public InsuranceTypeCore getEntityById(Integer id) {
        Optional<InsuranceType> insuranceTypeOptional = this.insuranceTypeDAO.getEntityById(id);
        try{
            if(insuranceTypeOptional.isEmpty()){
                throw new ObjectNotFoundException("Object was not found!", id);
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class InsuranceType with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        InsuranceType insuranceType = insuranceTypeOptional.get();
        return insuranceTypeMapper.modelToCore(insuranceType);
    }

    @Override
    public InsuranceTypeCore updateEntity(InsuranceTypeCore insuranceTypeCore, Integer id) {
        Optional<InsuranceType> insuranceTypeOptional = this.insuranceTypeDAO
                .updateEntity(insuranceTypeMapper.coreToModel(insuranceTypeCore), id);
        try {
            if (insuranceTypeOptional.isEmpty()) {
                throw new ObjectNotFoundException("Object was not found!", insuranceTypeCore.getId());
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class InsuranceType with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        logger.info("Object of class InsuranceType has been successfully updated.");
        return insuranceTypeMapper.modelToCore(insuranceTypeOptional.get());
    }

    @Override
    public void removeEntityById(Integer id) {
        this.insuranceTypeDAO.removeEntityById(id);
        logger.info("Object of class InsuranceType has been successfully deleted.");
    }
}