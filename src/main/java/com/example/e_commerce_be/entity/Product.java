package com.example.e_commerce_be.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String thumbnail;
    private double price;
    private double sale;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String status;
    @ManyToOne
    private Category category;
}
