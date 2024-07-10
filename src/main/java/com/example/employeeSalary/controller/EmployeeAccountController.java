package com.example.employeeSalary.controller;

import com.example.employeeSalary.entity.EmployeeAccount;
import com.example.employeeSalary.service.EmployeeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeAccountController {

    @Autowired
    private EmployeeAccountService service;

    @GetMapping("/NetSalary/{empId}")
    public EmployeeAccount calculateNetSalary(@PathVariable int empId) {
        return service.calculateAndUpdateNetSalary(empId);
    }

    @GetMapping("/all")
    public List<EmployeeAccount> getAllEmployees() {
        return service.getAllEmployees();
    }

    @PostMapping("/create")
    public EmployeeAccount createEmployee(@RequestBody EmployeeAccount employee) {
        return service.saveEmployee(employee);
    }
}
