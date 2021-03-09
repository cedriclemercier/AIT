package com.example.midterm.dao;

import com.example.midterm.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJPADao extends JpaRepository<Employee, Integer> {
}
