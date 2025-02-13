package com.example.demo.aop;

public class LeaveApplicationException extends RuntimeException{
    public LeaveApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
