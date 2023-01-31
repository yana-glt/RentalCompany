package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.LicenseCore;
import com.solvd.RentalCompany.mappers.mapperInterfaces.ILicenseMapper;
import com.solvd.RentalCompany.models.License;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LicenseMapper implements ILicenseMapper {
    private final static Logger logger = LogManager.getLogger(LicenseMapper.class);
    @Override
    public LicenseCore modelToCore(License license) {
        LicenseCore licenseCore = new LicenseCore();
        licenseCore.setId(license.getId());
        licenseCore.setClientId(license.getClientId());
        licenseCore.setNumber(license.getNumber());
        licenseCore.setIssueDate(license.getIssueDate());
        licenseCore.setExpiryDate(license.getExpiryDate());
        licenseCore.setValid(license.getValid());
        logger.info("Object of type License has been successfully mapped to LicenseCore type.");
        return licenseCore;
    }

    @Override
    public License coreToModel(LicenseCore licenseCore) {
        License license = new License();
        license.setId(licenseCore.getId());
        license.setClientId(licenseCore.getClientId());
        license.setNumber(licenseCore.getNumber());
        license.setIssueDate(licenseCore.getIssueDate());
        license.setExpiryDate(licenseCore.getExpiryDate());
        license.setValid(licenseCore.getValid());
        logger.info("Object of type LicenseCore has been successfully mapped to License type.");
        return license;
    }
}