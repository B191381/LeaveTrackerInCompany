package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.LeaveApplication;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private LeaveService leaveService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return savedEmployee;
    }

    @PostMapping("/applyleave")
    public LeaveApplication applyLeave(@RequestBody LeaveApplication leaveApplication) {
        return leaveService.applyLeave(leaveApplication);
    }

    @GetMapping("leavehistory/{employeeId}")
    public List<LeaveApplication> viewLeaveHistory(@PathVariable Long employeeId) {
        return leaveService.getEmployeeLeaves(employeeId);
    }
}
