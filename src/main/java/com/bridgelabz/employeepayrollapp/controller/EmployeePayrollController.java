package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {

    @GetMapping
    public String getWelcomeMessage() {
        return "Welcome to Employee Payroll App!";
    }
}
