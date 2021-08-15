package com.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
