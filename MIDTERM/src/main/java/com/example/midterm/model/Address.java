package com.example.midterm.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @EmbeddedId
    private AddressId id;

    // Loading address will load emp by default
    @ManyToOne(fetch = FetchType.EAGER)
    private Employee emp;

    // Loading address will load user by default
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

}