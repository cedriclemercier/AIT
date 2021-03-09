package com.example.midterm.service;

import com.example.midterm.dao.EmployeeJPADao;
import com.example.midterm.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeJPADao employeedao;

    @Override
    public void save(Employee employee) {
        System.out.println("created emp");
        employeedao.save(employee);


        try {
            System.out.println("Successful");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Employee> findAll() {
        return employeedao.findAll();
    }
}
