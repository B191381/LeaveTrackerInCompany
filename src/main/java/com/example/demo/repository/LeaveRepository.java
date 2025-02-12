package com.example.demo.repository;

import com.example.demo.model.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveApplication, Long> {
    List<LeaveApplication> findByEmployeeIdIsNotNull();
    List<LeaveApplication> findByEmployeeId(Long employeeId);
}
