package com.product.apirest.repository;

import com.product.apirest.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    Product findById(long id);
}
