package com.example.employeeSalary.controller;

import com.example.employeeSalary.entity.EmployeeAccount;
import com.example.employeeSalary.service.EmployeeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeAccountController {

    @Autowired
    private EmployeeAccountService service;

    @GetMapping("/NetSalary/{empId}")
    public ResponseEntity<EmployeeAccount> calculateNetSalary(@PathVariable int empId) {
        try {
            EmployeeAccount employee = service.calculateAndUpdateNetSalary(empId);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeAccount>> getAllEmployees() {
        List<EmployeeAccount> employees = service.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeAccount> createEmployee(@RequestBody EmployeeAccount employee) {
        EmployeeAccount createdEmployee = service.saveEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }
}
