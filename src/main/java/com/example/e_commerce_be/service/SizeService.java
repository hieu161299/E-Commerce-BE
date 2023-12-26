package com.example.e_commerce_be.service;

import com.example.e_commerce_be.entity.Size;

import java.util.List;

public interface SizeService {
    List<Size> findByProductId(Integer productId);
}
