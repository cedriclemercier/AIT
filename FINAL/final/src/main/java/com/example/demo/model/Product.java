package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Product {

    private static final CurrencyUnit CURRENCY = Monetary.getCurrency("USD");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    @JsonManagedReference
    private Company company;

    @ManyToMany
    @JoinTable(
            name="product_categories",
            joinColumns = @JoinColumn(name="product_id"),
            inverseJoinColumns = @JoinColumn(name="categories_id")
    )
    @JsonBackReference
    private Set<Categories> categories;

    @Transient
    private Monetary price;

    @Version
    private Long version;

    private int stock;

}
