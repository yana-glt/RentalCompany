package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.InsuranceTypeCore;
import com.solvd.RentalCompany.models.InsuranceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsuranceTypeMapper implements IInsuranceTypeMapper {
    private final static Logger logger = LogManager.getLogger(InsuranceTypeMapper.class);
    @Override
    public InsuranceTypeCore modelToCore(InsuranceType insuranceType) {
        InsuranceTypeCore insuranceTypeCore = new InsuranceTypeCore();
        insuranceTypeCore.setId(insuranceType.getId());
        insuranceTypeCore.setCategoryId(insuranceType.getCategoryId());
        insuranceTypeCore.setMandatoryPrice(insuranceType.getMandatoryPrice());
        insuranceTypeCore.setAdditionalPrice(insuranceType.getAdditionalPrice());
        logger.info("Object of type InsuranceType has been successfully mapped to InsuranceTypeCore type.");
        return insuranceTypeCore;
    }

    @Override
    public InsuranceType coreToModel(InsuranceTypeCore insuranceTypeCore) {
        InsuranceType insuranceType = new InsuranceType();
        insuranceType.setId(insuranceTypeCore.getId());
        insuranceType.setCategoryId(insuranceTypeCore.getCategoryId());
        insuranceType.setMandatoryPrice(insuranceTypeCore.getMandatoryPrice());
        insuranceType.setAdditionalPrice(insuranceTypeCore.getAdditionalPrice());
        logger.info("Object of type InsuranceTypeCore has been successfully mapped to InsuranceType type.");
        return insuranceType;
    }
}