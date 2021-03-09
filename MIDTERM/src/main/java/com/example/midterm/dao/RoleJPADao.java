package com.example.midterm.dao;

import com.example.midterm.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJPADao extends JpaRepository<Role, Integer> {
}
