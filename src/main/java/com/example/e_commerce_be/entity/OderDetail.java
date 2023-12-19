package com.example.e_commerce_be.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "oder_detail")
public class OderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int quantity;
    @OneToMany
    private List<Product> product;
}
