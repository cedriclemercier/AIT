package com.example.midterm.dao;

import com.example.midterm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path="users")
public interface UserJPADao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
