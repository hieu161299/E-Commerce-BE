package com.example.e_commerce_be.service.serviceImpl;

import com.example.e_commerce_be.entity.Image;
import com.example.e_commerce_be.repository.ImageRepository;
import com.example.e_commerce_be.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;
    @Override
    public List<Image> findAllByProductId(int productId) {
        return imageRepository.findAllByProduct_Id(productId);
    }
}
