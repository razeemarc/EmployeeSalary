package com.example.employeeSalary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EmployeeAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String name;
    private String email;
    private int baseSalary = 30000;
    private int leaveDays;
    private Integer netSalary; // Default to null
}
