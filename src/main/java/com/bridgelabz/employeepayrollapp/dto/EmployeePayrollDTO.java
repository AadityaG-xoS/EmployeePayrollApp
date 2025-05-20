package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class EmployeePayrollDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(
        regexp = "^[A-Z][a-zA-Z\\s]{2,}$",
        message = "Name must start with a capital letter and be at least 3 characters long"
    )
    public String name;

    @Min(value = 1, message = "Salary must be greater than 0")
    public long salary;

    public EmployeePayrollDTO() {
    }

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO{name='" + name + "', salary=" + salary + "}";
    }
}

