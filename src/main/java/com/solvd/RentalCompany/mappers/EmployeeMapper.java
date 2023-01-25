package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.EmployeeCore;
import com.solvd.RentalCompany.mappers.mapperInterfaces.IEmployeeMapper;
import com.solvd.RentalCompany.models.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeeMapper implements IEmployeeMapper {
    private final static Logger logger = LogManager.getLogger(EmployeeMapper.class);

    @Override
    public EmployeeCore modelToCore(Employee employee) {
        EmployeeCore employeeCore = new EmployeeCore();
        employeeCore.setId(employee.getId());
        employeeCore.setName(employee.getName());
        employeeCore.setSurname(employee.getSurname());
        employeeCore.setEmail(employee.getEmail());
        employeeCore.setPhone(employee.getPhone());
        employeeCore.setSalary(employee.getSalary());
        employeeCore.setLocationId(employee.getLocationId());
        employeeCore.setDepartmentId(employee.getDepartmentId());
        logger.info("Object of type Employee has been successfully mapped to EmployeeCore type.");
        return employeeCore;
    }

    @Override
    public Employee coreToModel(EmployeeCore employeeCore) {
        Employee employee = new Employee();
        employee.setId(employeeCore.getId());
        employee.setName(employeeCore.getName());
        employee.setSurname(employeeCore.getSurname());
        employee.setEmail(employeeCore.getEmail());
        employee.setPhone(employeeCore.getPhone());
        employee.setSalary(employeeCore.getSalary());
        employee.setLocationId(employeeCore.getLocationId());
        employee.setDepartmentId(employeeCore.getDepartmentId());
        logger.info("Object of type EmployeeCore has been successfully mapped to Employee type.");
        return employee;
    }
}