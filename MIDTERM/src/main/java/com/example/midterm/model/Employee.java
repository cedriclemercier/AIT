package com.example.midterm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "employee_info")
public class Employee {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_level")
    private Level level;

//    private Monetary baseSalary;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Address> addresses;

    /*@OneToOne(mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;*/

    /*@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id", referencedColumnName = "id")
    @JsonIgnore
    @MapsId
    private User user;*/
}
