package com.example.demo.aop;

public class EmployeeServiceException extends RuntimeException{
    public EmployeeServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
