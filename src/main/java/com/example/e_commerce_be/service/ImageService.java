package com.example.e_commerce_be.service;

import com.example.e_commerce_be.entity.Image;

import java.util.List;

public interface ImageService {
    List<Image> findAllByProductDetail_Id(int productId);
}
