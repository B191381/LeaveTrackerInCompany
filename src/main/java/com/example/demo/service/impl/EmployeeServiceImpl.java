package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.Manager;
import com.example.demo.repository.EmployeeRepository;
/*import com.example.demo.repository.ManagerRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Service
    public class EmployeeService {
        @Autowired
        private EmployeeRepository employeeRepository; // Repository is injected in Service

        // Method to save an employee@Autowired
        @Autowired
        private ManagerRepository managerRepository;

        public Employee saveEmployee(Employee employee) {
            // Fetch the existing manager from the database
            if (employee.getManager() != null && employee.getManager().getId() != null) {
                Manager existingManager = managerRepository.findById(employee.getManager().getId())
                        .orElseThrow(() -> new RuntimeException("Manager not found"));
                employee.setManager(existingManager); // Set the fetched manager
            }

            return employeeRepository.save(employee);
        }
    }
}*/


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
        if (employee.getManager() != null && employee.getManager().getId() != null) {
            Manager existingManager = managerRepository.findById(employee.getManager().getId())
                    .orElseThrow(() -> new RuntimeException("Manager not found"));
            employee.setManager(existingManager);
        }
        return employeeRepository.save(employee);
    }
}


