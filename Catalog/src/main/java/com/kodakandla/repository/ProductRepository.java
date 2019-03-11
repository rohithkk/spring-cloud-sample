package com.kodakandla.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodakandla.catalog.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Optional<Product> findByCode(String code);
}
