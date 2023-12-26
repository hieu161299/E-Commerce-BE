package com.example.e_commerce_be.repository;

import com.example.e_commerce_be.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand , Integer> {
    @Query(nativeQuery = true , value = "select * from brand")
    List<Brand> getAll();
}
