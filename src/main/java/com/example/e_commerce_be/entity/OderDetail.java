package com.example.e_commerce_be.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "oder_detail")
@Getter
@Setter
public class OderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int quantity;
    private double price;
    @OneToOne
    private Product product;
    @ManyToOne
    private Oder oder;
}
