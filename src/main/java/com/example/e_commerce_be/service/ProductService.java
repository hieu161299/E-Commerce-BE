package com.example.e_commerce_be.service;

import com.example.e_commerce_be.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ProductService {
    Page<Product> findAllByFilter(@Param("productName") String productName,
                                  @Param("minPrice") double minPrice,
                                  @Param("maxPrice") double maxPrice,
                                  @Param("brandName") String brandName,
                                  @Param("categoryName") String categoryName,
                                  @Param("color") String color ,
                                  Pageable pageable);
    Product findById(int id);
}
