package com.example.productms.repository;

import com.example.productms.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,Long> {
    Products findByName(String name);
}
