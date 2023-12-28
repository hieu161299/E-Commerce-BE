package com.example.e_commerce_be.controller;

import com.example.e_commerce_be.entity.Product;
import com.example.e_commerce_be.service.ImageService;
import com.example.e_commerce_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ImageService imageService;


    @GetMapping
    public ResponseEntity<?> getAllProduct(@RequestParam(value = "productName", defaultValue = "") String productName,
                                           @RequestParam(value = "minPrice") double minPrice,
                                           @RequestParam(value = "maxPrice" , required = false) double maxPrice,
                                           @RequestParam(value = "brandName", defaultValue = "") String brandName,
                                           @RequestParam(value = "categoryName", defaultValue = "") String categoryName,
                                           @RequestParam(value = "color", defaultValue = "") String color,
                                           @RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "12") int size){

        Pageable pageable = PageRequest.of(page, size);
        if (maxPrice == 0 ) {
            maxPrice = Double.MAX_VALUE;
        }
        return ResponseEntity.ok(productService.findAllByFilter(productName,minPrice,maxPrice,brandName,categoryName,color,pageable));
    }

    @GetMapping("/findById/{productId}")
    private ResponseEntity<?> findProductById(@PathVariable int productId){
        Product product = productService.findById(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/top5")
    private ResponseEntity<?> getTop5(){
        return ResponseEntity.ok(productService.getTopOder());
    }
}
