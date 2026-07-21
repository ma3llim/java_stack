package org.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggerEmployeeService {
    private static final Logger log = LoggerFactory.getLogger(LoggerEmployeeService.class);

    public void addEmployeeLogger() {
        log.info("Added New Employee");
    }

    public void updateEmployeeLogger() {
        log.info("Update Employee");
    }

    public void deleteEmployeeLogger() {
        log.warn("Delete Employee");
    }

    public void getAllEmployeeLogger() {
        log.info("All Employee");
    }

    public void getEmployeeByIdLogger() {
        log.info("Fetch Employee By Id");
    }

    public void EmployeeErrorLogger() {
        try {
            throw new RuntimeException("Something Went Wrong");
        } catch (RuntimeException e) {
            log.error("Failed while creating employee: {}", e.getMessage(), e);
        }
    }
}
