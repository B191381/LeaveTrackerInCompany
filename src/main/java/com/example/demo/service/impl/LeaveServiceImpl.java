package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.LeaveApplication;
import com.example.demo.model.LeaveStatus;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LeaveRepository;
import com.example.demo.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveServiceImpl implements LeaveService {


        @Autowired
        private LeaveRepository leaveRepository;
        @Autowired
        private EmployeeRepository employeeRepository;


        public LeaveApplication applyLeave(LeaveApplication leaveApplication) {
            return leaveRepository.save(leaveApplication);
        }

        public List<LeaveApplication> getEmployeeLeaves(Long employeeId) {
            return leaveRepository.findByEmployeeId(employeeId);
        }

        public List<LeaveApplication> findAll() {
            return leaveRepository.findAll();
        }

        public Optional<LeaveApplication> findById(Long id) {
            return leaveRepository.findById(id);
        }

        public void save(LeaveApplication leave) {
            leaveRepository.save(leave);
        }
}
