package com.example.employeeSalary.repository;

import com.example.employeeSalary.entity.EmployeeAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeAccountRepository extends JpaRepository<EmployeeAccount, Integer> {
}
