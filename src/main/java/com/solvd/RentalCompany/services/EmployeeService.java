package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.EmployeeCore;
import com.solvd.RentalCompany.dao.EmployeeDAO;
import com.solvd.RentalCompany.dao.IEmployeeDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.EmployeeMapper;
import com.solvd.RentalCompany.mappers.mapperInterfaces.IEmployeeMapper;
import com.solvd.RentalCompany.models.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class EmployeeService implements IEmployeeService{
    private final static Logger logger = LogManager.getLogger(EmployeeService.class);
    private final IEmployeeDAO employeeDAO = new EmployeeDAO();
    private final IEmployeeMapper employeeMapper = new EmployeeMapper();
    @Override
    public EmployeeCore createEntity(EmployeeCore employeeCore) {
        Employee employee = employeeMapper.coreToModel(employeeCore);
        Employee savedEmployee = this.employeeDAO.createEntity(employee);
        logger.info("Object of class Employee has been successfully created.");
        return employeeCore;
    }

    @Override
    public EmployeeCore getEntityById(Integer id) {
        Optional<Employee> employeeOptional = this.employeeDAO.getEntityById(id);
        try{
            if(employeeOptional.isEmpty()){
                throw new ObjectNotFoundException("Object was not found!", id);
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Employee with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        Employee employee = employeeOptional.get();
        return employeeMapper.modelToCore(employee);
    }

    @Override
    public EmployeeCore updateEntity(EmployeeCore employeeCore, Integer id) {
        Optional<Employee> employeeOptional = this.employeeDAO.updateEntity(employeeMapper.coreToModel(employeeCore), id);
        try {
            if (employeeOptional.isEmpty()) {
                throw new ObjectNotFoundException("Object was not found!", employeeCore.getId());
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Employee with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        logger.info("Object of class Employee has been successfully updated.");
        return employeeMapper.modelToCore(employeeOptional.get());
    }

    @Override
    public void removeEntityById(Integer id) {
        this.employeeDAO.removeEntityById(id);
        logger.info("Object of class Employee has been successfully deleted.");
    }
}