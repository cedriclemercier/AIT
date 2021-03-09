package com.example.midterm.service;

import com.example.midterm.model.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    List<Employee> findAll();
}