package com.example.e_commerce_be.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
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
    @ManyToOne
    private Category category;
    @OneToOne
    private Brand brand;
}
