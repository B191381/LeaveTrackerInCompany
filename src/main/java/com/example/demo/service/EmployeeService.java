package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.Manager;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
        public Employee saveEmployee(Employee employee);
}
