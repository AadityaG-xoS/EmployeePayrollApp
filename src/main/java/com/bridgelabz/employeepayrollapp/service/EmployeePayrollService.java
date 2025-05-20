package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private List<EmployeePayrollData> employeeList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeeList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == empId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        int id = employeeList.size() + 1;
        EmployeePayrollData newEmp = new EmployeePayrollData(id, empPayrollDTO.name, empPayrollDTO.salary);
        employeeList.add(newEmp);
        return newEmp;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = getEmployeePayrollDataById(empId);
        if (empData != null) {
            empData.setName(empPayrollDTO.name);
            empData.setSalary(empPayrollDTO.salary);
        }
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeeList.removeIf(emp -> emp.getId() == empId);
    }
}
