package com.example.demo.controller;

import com.example.demo.model.LeaveApplication;
import com.example.demo.repository.LeaveRepository;
import com.example.demo.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.LeaveStatus;
import com.example.demo.dto.commentRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manager")

public class ManagerController {
    @Autowired
    private LeaveService leaveService;



    @GetMapping("/viewLeaves")
    public List<LeaveApplication> viewAllLeaves() {
        System.out.println("Fetching only employee leave records...");
        return leaveService.findAll();
    }

    @PutMapping("/approve/{leaveId}")
    public String approveLeave(@PathVariable Long leaveId, @RequestBody commentRequest request) {
        LeaveApplication leave = leaveService.findById(leaveId).orElseThrow();
        leave.setStatus(LeaveStatus.APPROVED);
        leave.setManagerComments(request.getComment());
        leaveService.save(leave);
        return "Leave Approved";

    }

    @PutMapping("/reject/{leaveId}")
    public String rejectLeave(@PathVariable Long leaveId, @RequestBody commentRequest request) {
        LeaveApplication leave = leaveService.findById(leaveId).orElseThrow();
        leave.setStatus(LeaveStatus.REJECTED);
        leave.setManagerComments(request.getComment());
        leaveService.save(leave);
        return "Leave Rejected";
    }
}
