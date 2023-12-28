package com.example.e_commerce_be.payload.response;

import com.example.e_commerce_be.entity.Category;
import com.example.e_commerce_be.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Integer id;
    private String name;
    private String thumbnail;
    private double price;
    private double sale;
    private String description;
    private String status;
    private String color;
    private Category category;
    private List<Image> imageList;
}
