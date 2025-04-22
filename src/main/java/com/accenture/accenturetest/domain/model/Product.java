package com.accenture.accenturetest.domain.model;

import jakarta.persistence.*;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Branch branch;
}
