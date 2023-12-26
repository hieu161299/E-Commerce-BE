package com.example.e_commerce_be.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private String color; // mô tả màu sắc của sản phẩm
    private String gender; // sản phẩm dành cho nam hay nữ
    private LocalDateTime create_at;
    private LocalDateTime update_at;
    @ManyToOne
    private Category category;
}
