package com.kodakandla.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodakandla.catalog.entity.Product;
import com.kodakandla.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class ProductService {

	private ProductRepository productRepo;
	
	@Autowired
	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	public List<Product> getAllProducts(){
		log.info("retreiving all products");
		return productRepo.findAll();
	}
	
	public Optional<Product> findProductByCode(String code){
		log.info("retreiving product by code");
		return productRepo.findByCode(code);
	}
}
