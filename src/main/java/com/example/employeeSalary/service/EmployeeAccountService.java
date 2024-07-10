package com.example.employeeSalary.service;

import com.example.employeeSalary.entity.EmployeeAccount;
import com.example.employeeSalary.repository.EmployeeAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeAccountService {

    @Autowired
    private EmployeeAccountRepository repository;

    public EmployeeAccount calculateAndUpdateNetSalary(int empId) {
        EmployeeAccount employee = repository.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));
        int netSalary = employee.getBaseSalary() - (employee.getLeaveDays() * 1000);
        employee.setNetSalary(netSalary);
        return repository.save(employee);
    }

    public EmployeeAccount saveEmployee(EmployeeAccount employee) {
        return repository.save(employee);
    }

    public List<EmployeeAccount> getAllEmployees() {
        return repository.findAll();
    }
}
