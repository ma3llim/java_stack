package org.example.controller;

import jakarta.validation.Valid;
import org.example.exceptions.DuplicateException;
import org.example.exceptions.NotFoundException;
import org.example.dtos.EmployeeDto;
import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDto addEmployee(@Valid @RequestBody EmployeeDto employeeDto) throws DuplicateException {
        return employeeService.saveEmployee(employeeDto);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable String id) throws NotFoundException {
        return employeeService.getEmployeeById(id);
    }
}
