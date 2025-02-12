package com.example.demo.service;

import com.example.demo.model.LeaveApplication;
import com.example.demo.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LeaveService {



    public LeaveApplication applyLeave(LeaveApplication leaveApplication);

    public List<LeaveApplication> getEmployeeLeaves(Long employeeId);

    public List<LeaveApplication> findAll();

    public Optional<LeaveApplication> findById(Long id);

    public void save(LeaveApplication leave);
}
