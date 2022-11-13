package com.spring.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.products.dto.CouponDTO;
import com.spring.products.model.Product;
import com.spring.products.repo.ProductRepo;

@RestController
public class ProductController {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${coupon.url}")
	private String couponUrl;

	@PostMapping("/createProduct")
	public Product createProduct(@RequestBody Product product) {
		CouponDTO couponDTO = restTemplate.getForObject(couponUrl + product.getCouponCode(), CouponDTO.class);
		product.setPrice(product.getPrice().subtract(couponDTO.getDiscount()));
		return productRepo.save(product);
	}

}
