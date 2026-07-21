package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.service.LoggerEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logger")
@AllArgsConstructor
public class EmployeeControllerLogger {
    private final LoggerEmployeeService loggerEmployeeService;

    @PostMapping
    public ResponseEntity<String> addEmployee() {
        loggerEmployeeService.addEmployeeLogger();
        return ResponseEntity.ok("Employee added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateEmployee() {
        loggerEmployeeService.updateEmployeeLogger();
        return ResponseEntity.ok("Employee updated successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployee() {
        loggerEmployeeService.deleteEmployeeLogger();
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @GetMapping
    public ResponseEntity<String> getAllEmployees() {
        loggerEmployeeService.getAllEmployeeLogger();
        return ResponseEntity.ok("All employees fetched");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEmployeeById(@PathVariable Long id) {
        loggerEmployeeService.getEmployeeByIdLogger();
        return ResponseEntity.ok("Employee fetched by ID: " + id);
    }

    @GetMapping("/error")
    public ResponseEntity<String> triggerError() {
        loggerEmployeeService.EmployeeErrorLogger();
        return ResponseEntity.status(500).body("Error triggered");
    }
}
