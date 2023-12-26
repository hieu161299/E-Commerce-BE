package com.example.e_commerce_be.service.serviceImpl;

import com.example.e_commerce_be.entity.Brand;
import com.example.e_commerce_be.repository.BrandRepository;
import com.example.e_commerce_be.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandRepository;
    @Override
    public List<Brand> getAll() {
        return brandRepository.getAll();
    }
}
