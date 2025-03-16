package com.telusko.assetmanagmentapplication.service;

import com.telusko.assetmanagmentapplication.assetObjects.Employees;
import com.telusko.assetmanagmentapplication.assetObjects.Locations;
import com.telusko.assetmanagmentapplication.dto.EmployeeAddDTO;
import com.telusko.assetmanagmentapplication.dto.LocationAddDTO;
import com.telusko.assetmanagmentapplication.repository.EmployeesRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {

    private  final EmployeesRepo employeesRepo;

    public EmployeesService(EmployeesRepo employeesRepo) {
        this.employeesRepo = employeesRepo;
    }

    public List<Employees> getAllEmployees() {

        return employeesRepo.findAll();
    }

    public String addEmployee(@RequestBody EmployeeAddDTO employeeAddDTO) {
        Employees employees = new Employees();
        employees.setEmployeeName(employeeAddDTO.getEmployeeName());
        employees.setLocationId(employeeAddDTO.getLocationId());
        employees.setContactEmail(employeeAddDTO.getContactEmail());
        employees.setContactPhone(employeeAddDTO.getContactPhone());
        employeesRepo.save(employees);
        return "Employee saved successfully!";
    }

    public String updateEmployee(EmployeeAddDTO employeeAddDTO) {
        Optional<Employees> employees = employeesRepo.findById(employeeAddDTO.getEmployeeId());
        if (employees.isPresent()) {
            Employees employee = employees.get();
            employee.setEmployeeName(employeeAddDTO.getEmployeeName());
            employee.setLocationId(employeeAddDTO.getLocationId());
            employee.setContactEmail(employeeAddDTO.getContactEmail());
            employee.setContactPhone(employeeAddDTO.getContactPhone());
            employeesRepo.save(employee);
            return "Employee updated successfully!";
        }
        else {
            return "Employee with Id Not found";
        }
    }

}