package com.example.e_commerce_be.service.serviceImpl;

import com.example.e_commerce_be.entity.Size;
import com.example.e_commerce_be.repository.SizeRepository;
import com.example.e_commerce_be.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SizeServiceImpl implements SizeService {
    @Autowired
    SizeRepository sizeRepository;
    @Override
    public List<Size> findByProductId(Integer productId) {
        return sizeRepository.findByProduct_Id(productId);
    }
}
