package com.example.HW3.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@ToString
@Builder
public class User {

    @Id
    private int uid;
    private String name;
    private String nationality;
    private String email;

}
