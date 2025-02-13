package com.example.demo.service.impl;

import com.example.demo.aop.EmployeeServiceException;
import com.example.demo.aop.ManagerNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.Manager;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ManagerRepository managerRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ManagerRepository managerRepository) {
        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        try {
            if (employee.getManager() != null && employee.getManager().getId() != null) {
                Manager existingManager = managerRepository.findById(employee.getManager().getId())
                        .orElseThrow(() -> new ManagerNotFoundException("Manager not found with ID: " + employee.getManager().getId()));
                employee.setManager(existingManager);
            }
            return employeeRepository.save(employee);
        }
        catch (ManagerNotFoundException e) {
            throw e; // Custom exception for clarity
        }
        catch (Exception e) {
            throw new EmployeeServiceException("Error while saving employee: " + e.getMessage(), e);
        }
    }
}


