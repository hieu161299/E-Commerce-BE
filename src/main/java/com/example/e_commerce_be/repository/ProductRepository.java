package com.example.e_commerce_be.repository;

import com.example.e_commerce_be.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select p.* from product p join category c on c.id = p.category_id" +
            " join category_brand cb on c.id = cb.category_id join brand b on b.id = cb.brand_id" +
            " where (p.name like concat('%' , :productName , '%'))" +
            " and (p.price  between :minPrice and :maxPrice)\n" +
            " and (b.name like concat('%' , :brandName , '%'))" +
            " and (c.name like concat('%' , :categoryName , '%'))" +
            " and(p.color like concat('%' , :color , '%'))" +
            " group by p.id;" , nativeQuery = true)
    Page<Product> findAllByFilter(@Param("productName") String productName,
                                  @Param("minPrice") double minPrice,
                                  @Param("maxPrice") double maxPrice,
                                  @Param("brandName") String brandName,
                                  @Param("categoryName") String categoryName,
                                  @Param("color") String color ,
                                  Pageable pageable);

    Product findById(int id);
}
