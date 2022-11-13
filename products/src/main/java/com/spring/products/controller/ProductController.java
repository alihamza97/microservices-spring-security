package com.spring.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.products.model.Product;
import com.spring.products.repo.ProductRepo;

@RestController
public class ProductController {

	@Autowired
	private ProductRepo productRepo;

	@PostMapping("/createProduct")
	public Product createProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}

}
