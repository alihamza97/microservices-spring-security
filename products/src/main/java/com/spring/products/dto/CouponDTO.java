package com.spring.products.dto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class CouponDTO {

	private Long id;
	private String code;
	private BigDecimal discount;
	private String expDate;
}
