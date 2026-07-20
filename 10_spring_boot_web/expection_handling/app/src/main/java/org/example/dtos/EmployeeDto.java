package org.example.dtos;

import java.util.UUID;

public class EmployeeDto {
    private String name;
    private String email;

    public EmployeeDto(UUID id, String name, String email) {
        this.name = name;
        this.email = email;
    }

    public EmployeeDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
