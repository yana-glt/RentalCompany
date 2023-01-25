package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.DepartmentCore;
import com.solvd.RentalCompany.dao.DepartmentDAO;
import com.solvd.RentalCompany.dao.IDepartmentDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.DepartmentMapper;
import com.solvd.RentalCompany.mappers.mapperInterfaces.IDepartmentMapper;
import com.solvd.RentalCompany.models.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DepartmentService implements IDepartmentService{
    private final static Logger logger = LogManager.getLogger(DepartmentService.class);
    private final IDepartmentDAO departmentDAO = new DepartmentDAO();
    private final IDepartmentMapper departmentMapper = new DepartmentMapper();
    @Override
    public DepartmentCore createEntity(DepartmentCore departmentCore) {
        Department department = departmentMapper.coreToModel(departmentCore);
        Department savedDepartment = this.departmentDAO.createEntity(department);
        logger.info("Object of class Department has been successfully created.");
        return departmentCore;
    }

    @Override
    public DepartmentCore getEntityById(Integer id) {
        Optional<Department> departmentOptional = this.departmentDAO.getEntityById(id);
        try{
            if(departmentOptional.isEmpty()){
                throw new ObjectNotFoundException("Object was not found!", id);
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Department with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        Department department = departmentOptional.get();
        return departmentMapper.modelToCore(department);
    }

    @Override
    public DepartmentCore updateEntity(DepartmentCore departmentCore, Integer id) {
        Optional<Department> departmentOptional = this.departmentDAO
                .updateEntity(departmentMapper.coreToModel(departmentCore), id);
        try {
            if (departmentOptional.isEmpty()) {
                throw new ObjectNotFoundException("Object was not found!", departmentCore.getId());
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Department with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        logger.info("Object of class Department has been successfully updated.");
        return departmentMapper.modelToCore(departmentOptional.get());
    }

    @Override
    public void removeEntityById(Integer id) {
        this.departmentDAO.removeEntityById(id);
        logger.info("Object of class Department has been successfully deleted.");
    }
}