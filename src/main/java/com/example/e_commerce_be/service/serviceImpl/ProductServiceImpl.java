package com.example.e_commerce_be.service.serviceImpl;

import com.example.e_commerce_be.entity.Product;
import com.example.e_commerce_be.repository.ProductRepository;
import com.example.e_commerce_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Page<Product> findAllByFilter(String productName, double minPrice, double maxPrice, String brandName, String categoryName, String color, Pageable pageable) {
        return productRepository.findAllByFilter(productName ,minPrice ,maxPrice ,brandName ,categoryName ,color ,pageable);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductRepository.TopProduct> getTopOder() {
        return productRepository.getTopOder();
    }

}
