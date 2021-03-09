package com.example.midterm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "This field is required")
    private String username;

    @NotBlank(message = "This field is required")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "This field is required")
    @Transient
    private String passwordConfirm;

    @NotBlank(message = "This field is required")
    @Email(message = "Email should be valid")
    private String email;

    private boolean active;

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "emp_id", referencedColumnName = "id")
//    @JsonIgnore
//    @MapsId
//    private Employee emp;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Role> roles;
}
