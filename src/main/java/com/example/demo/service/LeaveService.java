package com.example.demo.service;

import com.example.demo.dto.commentRequest;
import com.example.demo.model.LeaveApplication;
import com.example.demo.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LeaveService {



    public String applyLeave(LeaveApplication leaveApplication);

    public List<LeaveApplication> getEmployeeLeaves(Long employeeId);

    public List<LeaveApplication> findAll();

    public Optional<LeaveApplication> findById(Long id);

    public String leaveApprove(Long leaveid, commentRequest request);

    public String leaveReject(Long leaveid, commentRequest request);

    public void save(LeaveApplication leave);
}
