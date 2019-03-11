package com.kodakandla.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodakandla.catalog.entity.Product;
import com.kodakandla.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

	ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("")
	public ResponseEntity<?> getProducts(){
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<?> getProductByCode(@PathVariable String code){
		
		Optional<Product> product = productService.findProductByCode(code);;
		
		if(product.isPresent())
			return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
		else
		{
			log.warn("did not find any product with code - {}", code);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
