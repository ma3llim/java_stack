package org.example.service;

import org.example.exceptions.DuplicateException;
import org.example.exceptions.NotFoundException;
import org.example.dtos.EmployeeDto;
import org.example.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();

    public EmployeeService() {
        employees.put("emp1", new Employee(UUID.randomUUID(), "John Doe", "john@example.com"));
        employees.put("emp2", new Employee(UUID.randomUUID(), "Jane Smith", "jane@example.com"));
    }

    public Employee getEmployeeById(String id) throws NotFoundException {
        Employee employee = employees.get(id);
        if (employee == null) {
            throw new NotFoundException("Employee with ID " + id + " not found");
        }
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employees.values().stream().toList();
    }

    public EmployeeDto saveEmployee(EmployeeDto employee) throws DuplicateException {
        boolean nameExists = employees.values().stream().anyMatch(existing -> existing.getName().equalsIgnoreCase(employee.getName()));
        if (nameExists) {
            throw new DuplicateException("Employee with name '" + employee.getName() + "' already exists");
        }
        UUID employedId = UUID.randomUUID();
        Employee newEmployee = new Employee(employedId, employee.getName(), employee.getEmail());
        employees.put(String.valueOf(employedId), newEmployee);
        return employee;
    }
}
