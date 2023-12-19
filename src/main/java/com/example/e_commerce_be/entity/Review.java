package com.example.e_commerce_be.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;
    private String status;
    private int rating;
    private LocalDate createAt;
    @ManyToOne
    private OderDetail oderDetail;
}
