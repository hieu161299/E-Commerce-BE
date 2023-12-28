package com.example.e_commerce_be.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String status;
    private int quantity;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
    @ManyToOne
    private Color color;
    @ManyToOne
    private Size size;
    @ManyToOne
    private Product product;
}
