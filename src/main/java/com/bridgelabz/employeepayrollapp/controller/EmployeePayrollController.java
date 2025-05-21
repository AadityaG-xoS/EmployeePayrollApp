package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;   // Add this import
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @GetMapping("/")
    public ResponseEntity<List<EmployeePayrollData>> getAllEmployees() {
        List<EmployeePayrollData> list = employeePayrollService.getEmployeePayrollData();
        return ResponseEntity.ok(list);
    }

    // GET employee by ID - return 404 if not found
    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeePayrollData> getEmployeeById(@PathVariable int id) {
        EmployeePayrollData empData = employeePayrollService.getEmployeePayrollDataById(id);
        if (empData == null) {
            return ResponseEntity.notFound().build();  // Return 404
        }
        return ResponseEntity.ok(empData);
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollData> createEmployee(@Valid @RequestBody EmployeePayrollDTO dto) {
        EmployeePayrollData createdEmp = employeePayrollService.createEmployeePayrollData(dto);
        return ResponseEntity.ok(createdEmp);
    }

    // PUT update - return 404 if employee not found
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeePayrollData> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeePayrollDTO dto) {
        EmployeePayrollData updatedEmp = employeePayrollService.updateEmployeePayrollData(id, dto);
        if (updatedEmp == null) {
            return ResponseEntity.notFound().build();  // Return 404
        }
        return ResponseEntity.ok(updatedEmp);
    }

    // DELETE - return 404 if employee not found
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        EmployeePayrollData empData = employeePayrollService.getEmployeePayrollDataById(id);
        if (empData == null) {
            return ResponseEntity.notFound().build();  // Return 404
        }
        employeePayrollService.deleteEmployeePayrollData(id);
        return ResponseEntity.ok("Deleted employee with ID = " + id);
    }
}


