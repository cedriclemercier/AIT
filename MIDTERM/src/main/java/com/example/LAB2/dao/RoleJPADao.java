package com.example.LAB2.dao;

import com.example.LAB2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJPADao extends JpaRepository<Role, Integer> {
}
