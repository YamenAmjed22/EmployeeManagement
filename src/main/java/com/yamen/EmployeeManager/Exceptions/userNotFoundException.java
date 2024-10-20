package com.yamen.EmployeeManager.Exceptions;

public class userNotFoundException extends RuntimeException {
    public userNotFoundException(String message) {
        super(message);
    }
}
