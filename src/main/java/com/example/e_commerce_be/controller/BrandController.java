package com.example.e_commerce_be.controller;

import com.example.e_commerce_be.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brands")
@CrossOrigin("*")
public class BrandController {
    @Autowired
    BrandService brandService;
    @GetMapping
    public ResponseEntity<?> getALlBrand(){
        return ResponseEntity.ok(brandService.getAll());
    }
}
