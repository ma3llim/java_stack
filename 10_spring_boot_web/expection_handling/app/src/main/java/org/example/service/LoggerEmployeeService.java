package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoggerEmployeeService {
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
