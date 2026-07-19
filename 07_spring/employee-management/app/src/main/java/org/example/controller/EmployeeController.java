package org.example.controller;

import org.example.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    List<Employee> employees = new ArrayList<>();

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employees;
    }

    @GetMapping("/employee-detail/{employeeId}")
    public Employee getEmployees(@PathVariable String employeeId){
        return employees.stream()
                .filter(employee -> employee.getId().equals(UUID.fromString(employeeId)))
                .findFirst()
                .orElseGet(()->{
                    System.out.println("Employee not found with ID: " + employeeId);
                    return null;
                }
        );
    }

    @GetMapping("/search")
    public List<Employee> searchEmployee(@RequestParam String name){
        if (name == null || name.trim().isEmpty()) {
            throw new RuntimeException("Employee Name is Required");
        }

        return employees.stream()
                .filter(employee -> employee.getName().toLowerCase().contains(name)).collect(Collectors.toList());
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(UUID.randomUUID());
        employees.add(employee);
        return employee;
    }

    @DeleteMapping("/delete/{employeeId}")
    public Boolean deleteEmployee(@PathVariable UUID employeeId){
        if(employeeId == null){
            System.out.println("Employee Id is required");
            return false;
        }

        boolean remove = employees.removeIf(employee -> employee.getId().equals(employeeId));
        if(remove){
            System.out.println("Employee deleted successfully: " + employeeId);
            return true;
        }else{
            System.out.println("Employee not found with ID: " + employeeId);
            return false;
        }
    }

    @PutMapping("/update/{employeeId}")
    public boolean updateEmployee(@PathVariable UUID employeeId, @RequestBody Employee updatedEmployee){
        if (employeeId == null || updatedEmployee == null) {
            System.out.println("Employee ID and data are required");
            return false;
        }

        return employees.stream().filter(
                employee -> employee.getId().equals(employeeId))
                .findFirst()
                .map(
                        employee -> {
                            employee.setName(updatedEmployee.getName());
                            System.out.println("Employee updated successfully: " + employeeId);
                            return true;
                        }
                ).orElseGet(() ->{
                    System.out.println("Employee not found with ID: " + employeeId);
                    return false;
                });

    }
}
