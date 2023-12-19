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
    private String status;
    private int quantity;
    private String color; // mô tả màu sắc của sản phẩm
    private String gender; // sản phẩm dành cho nam hay nữ
    @ManyToOne
    private Category category;
}
