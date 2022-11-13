package com.spring.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.coupon.model.Coupon;
import com.spring.coupon.repo.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponController {

	@Autowired
	private CouponRepo couponRepo;

	@RequestMapping(value = "/createCoupon", method = RequestMethod.POST)
	public Coupon create(@RequestBody Coupon coupon) {
		return couponRepo.save(coupon);
	}

	@RequestMapping(value = "/getCoupon/{code}", method = RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("code") String code) {
		return couponRepo.findByCode(code);
	}

}
