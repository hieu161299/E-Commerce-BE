package com.example.e_commerce_be.repository;

import com.example.e_commerce_be.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<Size, Integer> {

    List<Size> findByProduct_Id(Integer productId);
}
