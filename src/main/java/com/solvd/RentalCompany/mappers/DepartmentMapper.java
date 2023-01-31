package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.DepartmentCore;
import com.solvd.RentalCompany.mappers.mapperInterfaces.IDepartmentMapper;
import com.solvd.RentalCompany.models.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DepartmentMapper implements IDepartmentMapper {
    private final static Logger logger = LogManager.getLogger(DepartmentMapper.class);
    @Override
    public DepartmentCore modelToCore(Department department) {
        DepartmentCore departmentCore = new DepartmentCore();
        departmentCore.setId(department.getId());
        departmentCore.setName(department.getName());
        departmentCore.setMinSalary(department.getMinSalary());
        departmentCore.setMaxSalary(department.getMaxSalary());
        logger.info("Object of type Department has been successfully mapped to DepartmentCore type.");
        return departmentCore;
    }

    @Override
    public Department coreToModel(DepartmentCore departmentCore) {
        Department department = new Department();
        department.setId(departmentCore.getId());
        department.setName(departmentCore.getName());
        department.setMinSalary(departmentCore.getMinSalary());
        department.setMaxSalary(departmentCore.getMaxSalary());
        logger.info("Object of type DepartmentCore has been successfully mapped to Department type.");
        return department;
    }
}