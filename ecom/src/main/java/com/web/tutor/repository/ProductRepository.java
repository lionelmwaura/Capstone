package com.web.tutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.tutor.model.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {
	
}

