package com.example.e_commerce_be.repository;

import com.example.e_commerce_be.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    List<Image> findAllByProductDetail_Id(int productDetailId);

}
