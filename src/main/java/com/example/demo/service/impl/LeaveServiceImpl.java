package com.example.demo.service.impl;

import com.example.demo.aop.LeaveApplicationException;
import com.example.demo.aop.LeaveNotFoundException;
import com.example.demo.dto.commentRequest;
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


        public String applyLeave(LeaveApplication leaveApplication) {
            leaveRepository.save(leaveApplication);
            return "leave applied";
        }

        public List<LeaveApplication> getEmployeeLeaves(Long employeeId) {
            return leaveRepository.findByEmployeeId(employeeId);
        }

        public List<LeaveApplication> findAll() {
            return leaveRepository.findAll();
        }

        public Optional<LeaveApplication> findById(Long id) {
            try {
                return leaveRepository.findById(id)
                        .or(() -> {
                            throw new LeaveNotFoundException("Leave application not found with ID: " + id);
                        });
            } catch (Exception e) {
                throw new LeaveApplicationException("Error fetching leave application: " + e.getMessage(), e);
            }
        }

        public String leaveApprove(Long leaveid, commentRequest request) {
            LeaveApplication leave = leaveRepository.findById(leaveid).orElseThrow();
            leave.setStatus(LeaveStatus.APPROVED);
            leave.setManagerComments(request.getComment());
            leaveRepository.save(leave);
            return "leave approved";
        }

        public String leaveReject(Long leaveid, commentRequest request) {
            LeaveApplication leave = leaveRepository.findById(leaveid).orElseThrow();
            leave.setStatus(LeaveStatus.REJECTED);
            leave.setManagerComments(request.getComment());
            leaveRepository.save(leave);
            return "Leave Rejected";
        }

        public void save(LeaveApplication leave) {
            leaveRepository.save(leave);
        }
}
